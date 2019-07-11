package com.controller;

import javax.servlet.http.HttpServletRequest;

import com.check.RegisterCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
    @RequestMapping(value="register",method=RequestMethod.GET)
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value="registerSuccess",method=RequestMethod.POST)
    public String registerSuccess(Model model,String username,String password){
        if(RegisterCheck.registerCheck(username, password)){
            model.addAttribute("message", "注册成功！欢迎您！");
            return "success";
        }else{
            return "register";
        }
    }
}