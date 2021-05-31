package com.example.eshop.util;

import com.example.eshop.domain.Category;
import com.example.eshop.domain.Product;
import com.example.eshop.service.ICategoryService;
import com.example.eshop.service.IProductService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductTimerTask.java
 * @Description TODO
 * @createTime 2021-05-27 16:00:00
 */
@Component
public class ProductTimerTask extends TimerTask {

    @Resource
    private IProductService productService;
    @Resource
    private ICategoryService categoryService;

    private ServletContext application;

    public void setApplication(ServletContext application) {
        this.application = application;
    }

    @Override
    public void run() {
        System.out.println("----------productTimerTask.run------------");

        List<List<Product>> bigList = new ArrayList<List<Product>>();
        for(Category c:categoryService.queryByHot(true)) {
            List<Product> list = productService.queryByCategoryId(c.getId());
            bigList.add(list);
        }

        application.setAttribute("bigList", bigList);
    }
}
