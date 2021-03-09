package com.crx.cbdj.service.impl;

import com.crx.cbdj.dao.UserDao;
import com.crx.cbdj.entity.User;
import com.crx.cbdj.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    private UserDao userDao;

    public List<User> searchUserByName(String username) {
        return userDao.selectByUsername(username);
    }
}
