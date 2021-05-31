package com.example.eshop.service;

import com.example.eshop.domain.Account;
import com.example.eshop.domain.Category;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IAccountService.java
 * @Description TODO
 * @createTime 2021-05-25 12:58:00
 */
public interface IAccountService extends IBaseService<Account> {
    /**
     * @title: queryJoinAccount
     * @description: 查询类别，级联管理员
     * @author: linxinying
     * @updateTime: 2021/5/25 20:16
     * @params: 类别，String
     * @return: List<Category>
     */
    List<Account> queryJoinAccount();
}
