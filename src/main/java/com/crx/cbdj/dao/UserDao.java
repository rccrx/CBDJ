package com.crx.cbdj.dao;

import com.crx.cbdj.entity.User;

public interface UserDao {
    public User getUser(String email, String password);
}
