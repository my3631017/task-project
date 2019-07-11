package com.controller;

import com.pojo.Customer;
import com.service.CustomerService;
import com.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class TaskController {
    @Autowired
    CustomerService customerService;
    @Autowired
    JwtUtil jwtUtil;

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/register")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/toMessage")
    public String toMessage() {
        return "message";
    }

    @RequestMapping("/cancellation")
    public String cancellation(HttpServletRequest request, HttpServletResponse response) {
        String token = jwtUtil.generateToken(null, 3600000);
        request.getSession().removeAttribute("username");
//        把token设为null
        Cookie cookie = new Cookie("token", token);
        response.addCookie(cookie);
        return "login";
    }

    @RequestMapping(value = "/loginResult")
    public String Login(Customer customer, Model model, HttpSession session, HttpServletResponse response) throws Exception {
        String message = customerService.login(customer);
        if (message.equals("true")) {
            model.addAttribute("message", "登录成功，欢迎您！");
            String token = jwtUtil.generateToken(customer.getUsername(), 3600000);
//            输出token
            System.out.println(token);
            Cookie cookie = new Cookie("token", token);
//            cookie.setMaxAge(3600);
            response.addCookie(cookie);

            ServletContext context=session.getServletContext();
            customer=(Customer) context.getAttribute("user");
            System.out.println(customer.getUsername()+"享年"+customer.getAge()+"岁！");
            return "home";
        } else {
            model.addAttribute("message", message);
            return "login";
        }
    }

    @RequestMapping(value = "/registerResult", method = RequestMethod.POST)
    public String Register(Customer customer, Model model) throws Exception {
        String message = customerService.register(customer);
        if (message.equals("true")) {
            model.addAttribute("message", "注册成功，请登录:");
            return "login";
        } else {
            model.addAttribute("message", message);
            return "register";
        }
    }

}
