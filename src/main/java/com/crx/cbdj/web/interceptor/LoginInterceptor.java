package com.crx.cbdj.web.interceptor;

import com.crx.cbdj.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        System.out.println("LoginInterceptor preHandle: " + user);
        if (user == null) {
            /*
            不能写成"/login"，否则会跳到"http://localhost:8080/login"而不是"http://localhost:8080/CBDJ_war_exploded/login"，
            如果tomcat的URL是"http://localhost:8080"可以写成"/login"。
             */
            httpServletResponse.sendRedirect("login");
        }
        return true; // true表示放行
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor postHandle");
        System.out.println(modelAndView.getViewName());
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("LoginInterceptor afterCompletion");
    }
}
