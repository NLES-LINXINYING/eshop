package com.example.eshop.dao;

import com.example.eshop.domain.User;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IUserDao.java
 * @Description TODO
 * @createTime 2021-05-27 20:43:00
 */
public interface IUserDao {
    // 用户登录，成功返回该user
    User login(User user);
}
