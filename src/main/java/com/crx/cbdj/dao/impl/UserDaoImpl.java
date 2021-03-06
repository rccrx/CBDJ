package com.crx.cbdj.dao.impl;

import com.crx.cbdj.dao.UserDao;
import com.crx.cbdj.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User getUser(String email, String password) {
        logger.debug("调用了 getUser()，参数为{}, {}", email, password);

        User user = new User();
        user.setUsername("admin");
        user.setEmail(email);

        logger.info("成功获取 {} 信息", user.getUsername());
        logger.warn("获取 {} 失败", user.getEmail());
        return user;
    }
}
