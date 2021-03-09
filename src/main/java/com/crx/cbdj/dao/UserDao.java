package com.crx.cbdj.dao;

import com.crx.cbdj.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public List<User> selectAll();
    public void insert(User user);
    public void delete(Long userId);
    public User getById(Long userId);
    public void update(User user);
    /* 模糊查询 */
    public List<User> selectByUsername(String username);
    public User getByEmail(String email);
    /* 只是为了测试两个参数的mapper语法，邮箱密码登录用的是getByEmail */
    public User getUser(@Param("email") String email, @Param("password") String password);
}
