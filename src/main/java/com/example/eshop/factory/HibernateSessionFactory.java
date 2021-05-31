package com.example.eshop.factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName SqlSessionFactory.java
 * @Description TODO
 * @createTime 2021-05-24 10:51:00
 */
public class HibernateSessionFactory {

    private static final ThreadLocal<Session> SESSION_THREAD_LOCAL = new ThreadLocal<Session>();
    private static SessionFactory sessionFactory;

    private static Configuration configuration;
    private static ServiceRegistry serviceRegistry;

    static {
        try {
            configuration = new Configuration().configure();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("###  Error Creating SessionFactory ###");
            e.printStackTrace();
        }
    }

    // 保证单例
    private HibernateSessionFactory() {
    }

    public static Session getSession() throws HibernateException {
        Session session = (Session) SESSION_THREAD_LOCAL.get();

        if (session == null || !session.isOpen()) {
            if (sessionFactory == null) {
                rebuildSessionFactory();
            }
            session = (sessionFactory != null) ? sessionFactory.openSession() : null;
            SESSION_THREAD_LOCAL.set(session);
        }

        return session;
    }

    public static void rebuildSessionFactory() {
        try {
            configuration = new Configuration().configure();
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            System.err.println("###  Error Creating SessionFactory ###");
            e.printStackTrace();
        }
    }

    public static void closeSession() {
        Session session = SESSION_THREAD_LOCAL.get();
        SESSION_THREAD_LOCAL.set(null);

        if (session != null) {
            session.close();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Configuration getConfiguration() {
        return configuration;
    }
}
