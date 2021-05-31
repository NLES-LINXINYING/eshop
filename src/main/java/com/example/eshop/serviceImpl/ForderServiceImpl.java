package com.example.eshop.serviceImpl;

import com.example.eshop.domain.Forder;
import com.example.eshop.domain.Sorder;
import com.example.eshop.service.IForderService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ForderServiceImpl.java
 * @Description TODO
 * @createTime 2021-05-27 17:53:00
 */
@Service("forderService")
public class ForderServiceImpl extends BaseServiceImpl<Forder> implements IForderService {

    @Override
    public BigDecimal calTotal(Forder forder) {
        BigDecimal total = new BigDecimal(0.00);

        for(Sorder sorder:forder.getSorders()) {
            total.add(sorder.getPrice().multiply(new BigDecimal(sorder.getNumber())));
        }

        return total;
    }
}
