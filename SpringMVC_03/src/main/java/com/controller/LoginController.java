package com.controller;

import com.check.LoginCheck;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model, String username,String password) { // 从前台页面取得参数值
        String user_name = LoginCheck.check(username, password);
        if (user_name != null && user_name != "") {
            model.addAttribute("message", "登录成功！"+user_name+"，欢迎您！");
            return "success";
        } else {
            return "login";
        }
    }
}
