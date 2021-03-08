package com.crx.cbdj.web.controller;

import com.crx.cbdj.entity.User;
import com.crx.cbdj.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    /*
    自动装载，相当于"private UserService userService = SpringContext.getBean("userService");"，
    所以UserServiceImpl的@Service不用设置value。
     */
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"", "login"}, method = RequestMethod.GET)
    public String login() {
        logger.debug("调用了无参数login()方法");
        /*
        返回值指的是直接跳转到页面【"/WEB-INF/views"+login+".jsp"】，
        前后两个字符串是spring-mvc.xml配置的prefix和suffix
         */
        return "/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@RequestParam(required = true) String email, @RequestParam(required = true) String password, HttpServletRequest req) {
        logger.debug("调用了有参数login()方法");
        User user = userService.login(email, password);

        if (user != null) {
            req.getSession().setAttribute("user", user);
            return "redirect:/main"; // 重定向
        } else {
            req.setAttribute("message", "用户名或密码错误"); // 用于在前端页面中使用jsp获取这个数据
            return login();
        }
    }
}
