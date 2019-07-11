package com.listener;

import com.pojo.Customer;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener1 implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Customer customer=new Customer();
        customer.setUsername("晋首席");
        customer.setAge("33");
        ServletContext context=sce.getServletContext();
        context.setAttribute("user",customer);
        System.out.println("对象初始化完毕！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        // 在整个web应用销毁之前调用，将所有应用空间所设置的内容清空
        servletContext.removeAttribute("user");
        System.out.println("销毁工作完成...");
    }
}
