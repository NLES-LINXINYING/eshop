package com.example.eshop.controller;

import com.example.eshop.domain.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductController.java
 * @Description TODO
 * @createTime 2021-05-27 09:28:00
 */
@Controller("productController")
@Scope("prototype")
@RequestMapping("/product")
public class ProductController extends BaseController<Product> {
    @PostMapping("/query")
    @ResponseBody
    public Map<String, Object> queryJoinCategory(@RequestParam("name") String name, @RequestParam("page") int page, @RequestParam("rows") int size) {
        Logger logger = LogManager.getLogger(ProductController.class);
        logger.info("name=" + name + ",page=" + page + ",size=" + size);

        Map<String, Object> pageMap = new HashMap<String, Object>();
        List<Product> results = productService.queryJoinCaetory(name, page, size);
        pageMap.put("rows", results);

        Long total = productService.getCount(name);
        pageMap.put("total", total);

        return pageMap;
    }
}
