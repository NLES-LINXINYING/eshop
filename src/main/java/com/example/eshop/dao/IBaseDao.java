package com.example.eshop.dao;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName BaseDao.java
 * @Description TODO
 * @createTime 2021-05-27 20:44:00
 */
public interface IBaseDao<T> {
    void save(T t);

    void update(T t);

    void delete(int id);

    T get(int id);

    List<T> query();
}
