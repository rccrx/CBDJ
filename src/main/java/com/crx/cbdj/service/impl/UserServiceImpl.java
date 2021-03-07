package com.crx.cbdj.service.impl;

import com.crx.cbdj.common.context.SpringContext;
import com.crx.cbdj.dao.UserDao;
import com.crx.cbdj.entity.User;
import com.crx.cbdj.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = SpringContext.getBean("userDao");

    public User login(String email, String password) {
        return userDao.getUser(email, password);
    }
}
