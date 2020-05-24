package com.win.blog.service;

//基础服务类
public interface BaseServcie<E> {

    //添加新的数据
    int add(E pojo);

    //根据id删除指定数据
    int drop(E pojo);

    //根据id更新指定数据
    int modify(E pojo);

    //根据id查找指定数据
    E find(E pojo);
}
