package com.example.eshop.service;

import com.example.eshop.domain.Forder;

import java.math.BigDecimal;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IForderService.java
 * @Description TODO
 * @createTime 2021-05-27 17:52:00
 */
public interface IForderService extends IBaseService<Forder> {
    // 计算购物车总价格
    BigDecimal calTotal(Forder forder);
}
