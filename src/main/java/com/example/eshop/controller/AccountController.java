package com.example.eshop.controller;

import com.example.eshop.domain.Account;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountController.java
 * @Description 管理员
 * @createTime 2021-05-26 17:09:00
 */
@Controller("accountController")
@Scope("prototype")
@RequestMapping("/account")
public class AccountController extends BaseController<Account> {

    @GetMapping("/getAll")
    @ResponseBody
    public List<Account> getAll() {
        /**
         * @title: getAll
         * @description: 查询所有管理员信息
         * @author: linxinying
         * @updateTime: 2021/5/26 17:13
         * @params: []
         * @return: java.util.List<com.example.eshop.domain.Account>
         */

        return accountService.query();
    }
}
