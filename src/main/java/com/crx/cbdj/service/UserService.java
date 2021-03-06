package com.crx.cbdj.service;

import com.crx.cbdj.entity.User;

public interface UserService {
    public User login(String email, String password);
}
