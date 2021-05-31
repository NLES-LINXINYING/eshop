package com.example.eshop.dao.Impl;

import com.example.eshop.dao.IBaseDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BaseDaoImpl.java
 * @Description TODO
 * @createTime 2021-05-27 20:45:00
 */
@SuppressWarnings("unchecked")
@Repository("baseDao")
@Lazy(true)
public class BaseDaoImpl<T> implements IBaseDao<T> {

    private Class clazz; // 存储了当前操作的类型，即泛型T

    @Resource
    private SessionFactory sessionFactory;

    public BaseDaoImpl() {
        System.out.println("获取当前对象" + this);
        System.out.println("获取当前this对象的父类信息" + this.getClass().getSuperclass());
        System.out.println("获取当前this对象的父类信息(包括泛型信息)" + this.getClass().getGenericSuperclass());

        // 拿到泛型的参数类型
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        clazz = (Class) type.getActualTypeArguments()[0];
    }

    public Session getSession() {
        /**
         * @title getSession
         * @description 从当前线程获取session，如果没有就创建一个新的session
         * @author linxinying
         * @updateTime 2021/5/25 12:42
         * @params []
         * @return org.hibernate.Session
         */
        return this.sessionFactory.getCurrentSession();
    }

    @Transactional
    @Override
    public void save(T t) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(t);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw new RuntimeException(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T t) {
        getSession().update(t);
    }

    @Override
    public void delete(int id) {
        System.out.println(clazz.getSimpleName());
        String hql = "delete" + clazz.getSimpleName() + "as c where c.id=:id";
        getSession().createQuery(hql).setInteger("id", id).executeUpdate();
    }

    @Override
    public T get(int id) {
        return (T) getSession().get(clazz, id);
    }

    @Transactional
    @Override
    public List<T> query() {
        String hql = "from " + clazz.getSimpleName();

        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        List<T> results = null;
        try {
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
