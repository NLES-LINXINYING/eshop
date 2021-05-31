package com.example.eshop.serviceImpl;

import com.example.eshop.domain.Forder;
import com.example.eshop.domain.Product;
import com.example.eshop.domain.Sorder;
import com.example.eshop.service.ISorderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SorderServiceImpl.java
 * @Description TODO
 * @createTime 2021-05-27 17:52:00
 */
@Service("sorderService")
public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements ISorderService {

    @Transactional
    @Override
    public Forder addSorder(Forder forder, Product product) {
        /**
         * @title: addSorder
         * @description: 添加新的购物项到购物车
         * @author: linxinying
         * @updateTime: 2021/5/27 17:57
         * @params: [forder, product]
         * @return: com.example.eshop.domain.Forder
         */

        boolean isHave = false; // 用来标记有没有重复项

        // 拿到当前商品的购物项
        Sorder sorder = productToSorder(product);
        // 判断是否有重复的购物项，如果重复，直接在原来的购物项添加数量
        for (Sorder s : forder.getSorders()) {
            if (s.getProduct().getId() == (sorder.getProduct().getId())) {
                // 购物项重复，添加数量
                s.setNumber(s.getNumber() + sorder.getNumber());
                isHave = true;
                break;
            }
        }

        // 当前购物项在购物车中不存在，新增一项
        if (!isHave) {
            forder.getSorders().add(sorder);
        }
        return forder;
    }

    @Override
    public Sorder productToSorder(Product product) {
        /**
         * @title: productToSorder
         * @description: 将商品转换（绑定）到购物项
         * @author: linxinying
         * @updateTime: 2021/5/27 18:28
         * @params: [product]
         * @return: com.example.eshop.domain.Sorder
         */

        Sorder sorder = new Sorder();
        sorder.setName(product.getName());
        sorder.setNumber(1);
        sorder.setPrice(product.getPrice());
        sorder.setProduct(product);
        return sorder;
    }
}
