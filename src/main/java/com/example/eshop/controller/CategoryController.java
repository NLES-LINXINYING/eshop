package com.example.eshop.controller;

import com.example.eshop.domain.Account;
import com.example.eshop.domain.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CategoryController.java
 * @Description TODO
 * @createTime 2021-05-25 10:14:00
 */
@Controller("categoryController")
@Scope("prototype")
@RequestMapping("/category")
public class CategoryController extends BaseController<Category> {

    private final Logger LOGGER = LogManager.getLogger();

    @PostMapping("/query")
    @ResponseBody
    public Map<String, Object> queryJoinAccount(@RequestParam("type") String type, @RequestParam("page") int page, @RequestParam("rows") int size) {

        Map<String, Object> pageMap = new HashMap<String, Object>();
        // 所有记录
        List<Category> categoryList = categoryService.queryJoinAccount(type, page, size);
        pageMap.put("rows", categoryList);
        // 总记录数
        Long total = categoryService.getCount(type);
        pageMap.put("total", total);

        return pageMap;
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteByIds(@RequestParam("ids") String ids) {
        categoryService.deleteByIds(ids);
        return "true";
    }

    @PostMapping("/save")
    @ResponseBody
    public String save(@RequestParam("type") String type, @RequestParam("hot") Byte hot, @RequestParam("account.id") Integer aid) {
        System.out.println("-------------------save:" + type + "," + hot + "," + aid);
        Account account = new Account();
        account.setId(aid);
        Category category = new Category(type, hot, account);
        categoryService.save(category);
        return "true";
    }
}
