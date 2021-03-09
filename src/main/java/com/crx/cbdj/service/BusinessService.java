package com.crx.cbdj.service;

import com.crx.cbdj.entity.User;

import java.util.List;

public interface BusinessService {

    /* 模糊查询 */
    public List<User> searchUserByName(String username);
}
