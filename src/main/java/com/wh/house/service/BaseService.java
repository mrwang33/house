package com.wh.house.service;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T> {

    // 获取所有
    List<T> getAll();

    // 根据id获取单个
    T getById(Serializable id);

    // 根据id更新
    int updateById(T t);

    // 新增
    Object save(T t);

    // 删除
    int deleteById(Serializable id);

}
