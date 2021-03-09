package com.crx.cbdj.web.controller;


import com.crx.cbdj.entity.User;
import com.crx.cbdj.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    // 这个方法的请求路径是"http://localhost:8080/CBDJ_war_exploded/business/findUserByName?username=a"
    @RequestMapping(value = "findUserByName", method = RequestMethod.GET)
    public List<User> findUserByName(String username) {
        return businessService.searchUserByName(username);
        // 必须依赖jackson-core和jackson-databind，否则无法将List自动转化成JSON格式，会500错误提示"No converter found for return value of type: class java.util.ArrayList"
    }
}
