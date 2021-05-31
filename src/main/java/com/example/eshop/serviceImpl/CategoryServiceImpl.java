package com.example.eshop.serviceImpl;

import com.example.eshop.domain.Category;
import com.example.eshop.service.ICategoryService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CategoryServiceImpl.java
 * @Description TODO
 * @createTime 2021-05-24 11:38:00
 */
@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category> implements ICategoryService {

    @Transactional
    @Override
    public List<Category> queryJoinAccount(String type, int page, int size) {
        String hql = "from Category c left join fetch c.account where c.type like :type";

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<Category> results = null;
        try {
            results = session.createQuery(hql)
                    .setString("type", "%" + type +"%")
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return results;
    }

    @Transactional
    @Override
    public Long getCount(String type) {
        String hql = "select count(c) from Category c where c.type like :type";

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        Long total = 0L;
        try {
            total = (Long) session.createQuery(hql).setString("type", "%" + type +"%").uniqueResult();

        } catch (HibernateException e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return total;
    }

    @Transactional
    @Override
    public void deleteByIds(String ids) {
        String hql = "delete from Category c where c.id in(" + ids +")";

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.createQuery(hql).executeUpdate();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Transactional
    @Override
    public List<Category> queryByHot(boolean hot) {
        String hql = "from Category c  where c.hot = :hot";

        byte hot_byte = (byte) (hot?1:0);

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<Category> results = null;
        try {
            results = session.createQuery(hql).setByte("hot", hot_byte).list();

        } catch (HibernateException e) {
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
        return results;
    }
}
