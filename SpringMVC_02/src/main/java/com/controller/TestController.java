package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping("/image")
    public String toImage(Model model, HttpServletRequest request) {
//        model.addAttribute("ip",request.getRemoteAddr());
        List<String> list = new ArrayList();
        list.add("中国队大胜美国队！");
        list.add("中国队大败美国队！");
        list.add("好像是一个意思？");
        model.addAttribute("list", list);
        return "helloImage";
    }

    @RequestMapping(value = "/test")
    public String toURL(String name,Model model) {
        model.addAttribute("message", name);
        return "url";
    }

    @RequestMapping("/response")
    public String toResponse(){
        return "response";
    }
}
