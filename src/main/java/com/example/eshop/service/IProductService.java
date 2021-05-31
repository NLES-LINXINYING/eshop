package com.example.eshop.service;

import com.example.eshop.domain.Product;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IProductService.java
 * @Description TODO
 * @createTime 2021-05-27 09:20:00
 */
public interface IProductService extends IBaseService<Product> {
    List<Product> queryJoinCaetory(String name, int page, int size);

    Long getCount(String name);

    // 根据热点类别查询推荐商品（仅仅查询前四个）
    List<Product> queryByCategoryId(int cid);
}
