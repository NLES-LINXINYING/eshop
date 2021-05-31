package com.example.eshop.dao.Impl;

import com.example.eshop.dao.IBaseDao;
import com.example.eshop.dao.IUserDao;
import com.example.eshop.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserDaoImpl.java
 * @Description TODO
 * @createTime 2021-05-27 20:44:00
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

    @Transactional
    @Override
    public User login(User user) {
        String hql = "from User u where u.login=:login and u.pass=:pass";
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        User result = null;
        try {
            result = (User) session.createQuery(hql).setString("login", user.getLogin()).setString("pass", user.getPass()).uniqueResult();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return result;
    }

}
