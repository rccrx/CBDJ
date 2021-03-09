package com.crx.cbdj.service;

import com.crx.cbdj.entity.User;

import java.util.List;

public interface UserService {
    public List<User> selectAll();
    public void insert(User user);
    public void delete(Long userId);
    public User getById(Long userId);
    public void update(User user);
    public List<User> selectByUsername(String username);
    public User getByEmail(String email);
    public User login(String email, String password);
    /* 只是为了测试两个参数的mapper语法，邮箱密码登录用的是login */
    public User getUser(String email, String password);
}
