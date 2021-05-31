package com.example.eshop.service;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName IBaseService.java
 * @Description service基础类，使用泛型
 * @createTime 2021-05-25 12:03:00
 */
public interface IBaseService<T> {
    void save(T t);

    void update(T t);

    void delete(int id);

    T get(int id);

    List<T> query();
}
