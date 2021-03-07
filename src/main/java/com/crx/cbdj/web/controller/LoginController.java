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
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        SpringContext context = new SpringContext();
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.login(email, password);
        System.out.println(user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        SpringContext context = new SpringContext();
        UserService userService = (UserService) context.getBean("userService");
        User user = userService.login(email, password);

        if (user != null) {
            resp.sendRedirect("./main.jsp"); // 如果这里写成"/main.jsp"，则路径是"http://localhost:8080/main.jsp"，不是"http://localhost:8080/CBDJ_war_exploded/main.jsp"
        } else {
            req.setAttribute("message", "用户名或密码错误"); // 用于在前端页面中使用jsp获取这个数据
            req.getRequestDispatcher("./index.jsp").forward(req, resp);
        }
    }
}
