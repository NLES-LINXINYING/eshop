package com.example.eshop.listener;

import com.example.eshop.domain.Category;
import com.example.eshop.domain.Product;
import com.example.eshop.service.ICategoryService;
import com.example.eshop.service.IProductService;
import com.example.eshop.util.ProductTimerTask;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName InitDataListener.java
 * @Description 监听器是web组件，是tomcat实例化的，不是spring实例化的，不能放到spring中
 * @createTime 2021-05-27 15:04:00
 */
public class InitDataListener implements ServletContextListener {

    private ApplicationContext context;
    private ProductTimerTask productTimerTask;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {

        context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
        productTimerTask = (ProductTimerTask) context.getBean("productTimerTask");

        // 把内置对象交给productTimerTask, 因为productTimerTask拿不到application，只能由监听器set给它
        productTimerTask.setApplication(event.getServletContext());

        // 通过设置定时器，让首页的数据每一个小时同步一次（配置为守护线程）
        new Timer(true).schedule(productTimerTask, 0, 1000 * 60 * 60);
    }
}
