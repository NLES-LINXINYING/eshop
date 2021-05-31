package com.example.eshop.controller;

import com.example.eshop.domain.Forder;
import com.example.eshop.domain.Product;
import com.example.eshop.domain.Sorder;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SorderController.java
 * @Description TODO
 * @createTime 2021-05-27 19:51:00
 */
@Controller("sorderController")
@Scope("prototype")
@RequestMapping("/sorder")
public class SorderController extends BaseController<Sorder> {

    @RequestMapping("/addSorder")
    public String addSorder(@RequestParam("productId") Integer pid) {
        // 1. 根据pid获取对应product
        Product product = productService.get(pid);

        // 2. 判断当前session是否有购物车，如果没有则创建
        if(session.getAttribute("forder") == null) {
            // 创建新的购物车，存储到session中
            session.setAttribute("forder", new Forder(new HashSet<Sorder>()));
        }

        // 3. 把商品信息转换为sorder，并且添加到购物车（判断是否有重复项）
        Forder forder = (Forder) session.getAttribute("forder");
        forder = sorderService.addSorder(forder, product);

        // 4. 计算购物车所有购物项总价格
        forder.setTotal(forderService.calTotal(forder));

        // 5. 把新的购物车存到session
        session.setAttribute("forder", forder);

        return "showChart";
    }
}
