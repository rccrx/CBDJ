package com.crx.cbdj.service.test;

import com.crx.cbdj.entity.User;
import com.crx.cbdj.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.DigestUtils;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-context-druid.xml", "classpath:spring-context-mybatis.xml"})
// classpath指的是target/cbdj-1.0.0-SNAPSHOT/WEB-INF/classes目录
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSelectAll() {
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("Tony");
        user.setPassword("zxcvbn");
        user.setEmail("tony@qq.com");
        userService.insert(user);
    }

    @Test
    public void testDelete() {
        userService.delete(3L);
    }

    @Test
    public void testGetById() {
        User user = userService.getById(6L);
        System.out.println(user);
    }

    @Test
    public void testUpdate() {
        User user = userService.getById(1L);
        user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        userService.update(user);
    }

    @Test
    public void testMD5() {
        System.out.println(DigestUtils.md5DigestAsHex("123456".getBytes())); //e10adc3949ba59abbe56e057f20f883e
    }

    @Test
    public void testSelectByUsername() {
        List<User> users = userService.selectByUsername("o");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testLogin() {
        User user = userService.login("tom@qq.com", "123456");
        System.out.println(user);
    }

    @Test
    public void testGetUser() {
        User user = userService.getUser("amy@qq.com", "654321");
        System.out.println(user);
    }
}
