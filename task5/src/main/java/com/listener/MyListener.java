package com.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.HashSet;

public class MyListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session=se.getSession();
        ServletContext context=session.getServletContext();
        //用set集合来存储session对象
//        HashSet<HttpSession> sessionSet=new HashSet<>();
        HashSet<HttpSession> sessionSet=(HashSet<HttpSession>) context.getAttribute("sessionSet");
        if(sessionSet==null){
            sessionSet=new HashSet<>();
            context.setAttribute("sessionSet", sessionSet);
        }
        //这里主要是为了检验用户是否登录，登录的话强制移除该session，加入新session
        for(HttpSession s : sessionSet){
            if(session.getAttribute("nickname")==s.getAttribute("nickname")){
                sessionSet.remove(s);
            }
        }
        sessionSet.add(session);
        //存储在线人数，利用了set集合不重复的特性，避免了重复登录
        context.setAttribute("lineCount", sessionSet.size());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        if (context.getAttribute("lineCount") == null) {
            context.setAttribute("lineCount", 0);
        } else {
            int lineCount = (Integer) context.getAttribute("lineCount");
            if (lineCount < 1) {
                lineCount = 1;
            }
            context.setAttribute("lineCount", lineCount - 1);
        }
        HttpSession session = se.getSession();
        HashSet<HttpSession> sessionSet = (HashSet<HttpSession>)context.getAttribute("sessionSet");
        if(sessionSet!=null){
            sessionSet.remove(session);
        }
    }
}
