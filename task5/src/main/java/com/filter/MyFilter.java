package com.filter;

import com.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MyFilter extends OncePerRequestFilter {
    @Autowired
    JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //不过滤的请求，登录和注册都不过滤
//        String[] unFiltered = new String[]{"/", "/login", "/register", "/loginResult", "/registerResult"};
        List<String> list = new ArrayList<>();
        list.add("/");
        list.add("/login");
        list.add("/register");
        list.add("/loginResult");
        list.add("/registerResult");
        String uri = request.getRequestURI();//请求的uri
        System.out.println(uri);

        boolean doFilter = true;//doFilter为true则过滤，为false则不过滤
        //判断unFiltered中是否包含请求的uri，包含则不进行过滤
        for (String s : list) {
            if (uri.equals(s)) {
                doFilter = false;
                break;
            }
        }

        if (doFilter) {
            //过滤的请求直接返回的登录界面
//            request.setAttribute("message", "需要登录");
//            request.getRequestDispatcher("/login").forward(request, response);
//            System.out.println("过滤");
            String token = null;
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
            Map<String, Object> map = jwtUtil.parseToken(token);
            String message = (String) map.get("ERR_MSG");
            if (message != null) {
                request.setAttribute("message", message);
                request.getRequestDispatcher("/login").forward(request, response);
            }
            String username = (String) map.get("username");
            if (username == null) {
                // 跳转到登录页面
                request.setAttribute("message", "您还没用登录，请登录：");
                request.getRequestDispatcher("/login").forward(request, response);
//            response.sendRedirect("/login");
            }
            filterChain.doFilter(request, response);
            System.out.println("放行");
        } else {
            //不过滤的请求，直接放行
            System.out.println("不过滤");
            filterChain.doFilter(request, response);
        }
    }
}
