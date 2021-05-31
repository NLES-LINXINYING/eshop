package com.example.eshop.controller;

import com.example.eshop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BaseController.java
 * @Description controller基础类，统一获取request，response， session
 * @createTime 2021-05-25 13:27:00
 */
@Controller("baseController")
@Scope("prototype")
public class BaseController<T> {

    @Resource
    protected ICategoryService categoryService;
    @Resource
    protected IAccountService accountService;
    @Resource
    protected IProductService productService;
    @Resource
    protected IForderService forderService;
    @Resource
    protected ISorderService sorderService;
    @Resource
    protected IUserService userService;

    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    @Autowired
    protected HttpSession session;

    public void setAttributes(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }
}
