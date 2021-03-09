package com.crx.cbdj.service.impl;

import com.crx.cbdj.dao.UserDao;
import com.crx.cbdj.entity.User;
import com.crx.cbdj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    public List<User> selectAll() {
        return userDao.selectAll();
    }

    public void insert(User user) {
        userDao.insert(user);
    }

    public void delete(Long userId) {
        userDao.delete(userId);
    }

    public User getById(Long userId) {
        return userDao.getById(userId);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public List<User> selectByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    public User login(String email, String password) {
        User user = userDao.getByEmail(email);
        if (user != null) {
            String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
            if (md5Password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String email, String password) {
        return userDao.getUser(email, password);
    }
}
