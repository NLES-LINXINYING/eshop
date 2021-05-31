package com.example.eshop.serviceImpl;

import com.example.eshop.domain.User;
import com.example.eshop.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2021-05-28 08:34:00
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    @Override
    public User login(User user) {
        return userDao.login(user);
    }
}
