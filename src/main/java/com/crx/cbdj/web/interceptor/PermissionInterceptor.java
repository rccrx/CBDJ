package com.crx.cbdj.web.interceptor;

import com.crx.cbdj.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PermissionInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("PermissionInterceptor preHandle");
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("PermissionInterceptor postHandle");
        /*
         好像如果LoginInterceptor和PermissionInterceptor都进行拦截，
         会先调用后添加到spring-mvc.xml的拦截器，比如先调用PermissionInterceptor。
         */
        if (modelAndView.getViewName().endsWith("login")) {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (user != null) {
                httpServletResponse.sendRedirect("main");
            }
        }
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("PermissionInterceptor afterCompletion");
    }
}
