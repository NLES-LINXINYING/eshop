package com.example.eshop.serviceImpl;

import com.example.eshop.domain.Product;
import com.example.eshop.service.IProductService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductServiceImpl.java
 * @Description 商品业务实现类
 * @createTime 2021-05-27 09:26:00
 */
@Service("productService")
public class ProductServiceImpl extends BaseServiceImpl<Product> implements IProductService {
    @Transactional
    @Override
    public List<Product> queryJoinCaetory(String name, int page, int size) {
        String hql = "from Product p left join fetch p.category where p.name like :name";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<Product> results = null;
        try {
            results = session.createQuery(hql).setString("name", "%" + name + "%").setFirstResult((page - 1) * size).setMaxResults(size).list();
            //transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    @Override
    public Long getCount(String name) {
        String hql = "select count(p) from Product p where p.name like :name";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Long total = 0L;
        try {
            total = (Long) session.createQuery(hql).setString("name", "%" + name + "%").uniqueResult();
            //transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return total;
    }

    @Transactional
    @Override
    public List<Product> queryByCategoryId(int cid) {
        String hql = "from Product p join fetch p.category " + "where p.commend = 1 and p.open = 1 and p.category.id = :cid order by p.date desc";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<Product> results = null;
        try {
            results = session.createQuery(hql).setInteger("cid", cid).setFirstResult(0).setMaxResults(4).setCacheable(true).list();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return results;
    }
}
