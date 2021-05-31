package com.example.eshop.service;

import com.example.eshop.domain.Forder;
import com.example.eshop.domain.Product;
import com.example.eshop.domain.Sorder;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ISorderService.java
 * @Description TODO
 * @createTime 2021-05-27 17:50:00
 */
public interface ISorderService extends IBaseService<Sorder> {
    // 添加购物项，返回新的购物车
    Forder addSorder(Forder forder, Product product);

    // 把商品数据转换为购物项
    public Sorder productToSorder(Product product);
}
