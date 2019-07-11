package com.controller;

import com.pojo.Page;
import com.pojo.User;
import com.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/user", method = RequestMethod.GET)
public class UserController {
    @Autowired
    UserDaoService userDaoService;
    @Autowired
    Page p;

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public String findUsersByPage(int page, Model model) {
        try {
            p.setTotalUsers(userDaoService.findUsers().size());
            p.setCurrentPage(page);
            List<User> list = userDaoService.findUsersByPage((page - 1) * p.getPageSize(), p.getPageSize());
//            查询结果是list集合
            model.addAttribute("list", list);
            model.addAttribute("page", p);
            return "home";
        } catch (Exception e) {
            model.addAttribute("message", "未能获取数据");
            return "message";
        }
    }
}

