package com.crx.cbdj.web.controller;

import com.crx.cbdj.common.context.SpringContext;
import com.crx.cbdj.entity.User;
import com.crx.cbdj.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SpringContext context = new SpringContext();
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.login("abc@qq.com", "123");
        System.out.println(user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        SpringContext context = new SpringContext();
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.login(email, password);
        System.out.println(user);
    }
}
