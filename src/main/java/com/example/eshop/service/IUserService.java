package com.example.eshop.service;

import com.example.eshop.domain.User;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IUserService.java
 * @Description TODO
 * @createTime 2021-05-28 08:30:00
 */
public interface IUserService extends IBaseService<User> {
    User login(User user);
}
