package com.example.eshop.service;

import com.example.eshop.domain.Category;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CategoryService.java
 * @Description 只要添加 CateService 本身需要的新的方法，公共方法在 IBaseService 中
 * @createTime 2021-05-24 11:37:00
 */
public interface ICategoryService extends IBaseService<Category> {

    // 查询类别，级联管理员
    List<Category> queryJoinAccount(String type, int page, int size);

    // 根据关键字查询总记录数
    Long getCount(String type);

    // 根据ids删除多条记录
    void deleteByIds(String ids);

    // 根据布尔值查询热点或非热点类别
    List<Category> queryByHot(boolean hot);
}
