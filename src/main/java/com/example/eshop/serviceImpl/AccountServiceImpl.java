package com.example.eshop.serviceImpl;

import com.example.eshop.domain.Account;
import com.example.eshop.domain.Category;
import com.example.eshop.service.IAccountService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName AccountServiceImpl.java
 * @Description TODO
 * @createTime 2021-05-25 13:00:00
 */
@Service("accountService")
public class AccountServiceImpl extends BaseServiceImpl<Account> implements IAccountService {

    @Override
    public List<Account> queryJoinAccount() {
        //String hql = "from Category c where c.type like :type";
        String hql = "from Account";

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<Account> results = null;
        try {
            //results = session.createQuery(hql).setString("type", "%" + type +"%").list();
            results = session.createQuery(hql).list();

            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }

        return results;
    }
}
