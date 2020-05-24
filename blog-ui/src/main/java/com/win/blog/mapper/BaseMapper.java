package com.win.blog.mapper;

//基础mapper接口
public interface BaseMapper<E> {

    //添加新的数据
    int insert(E pojo);

    //根据id删除指定数据
    int delete(E pojo);

    //根据id更新指定数据
    int update(E pojo);

    //根据id查找指定数据
    E select(E pojo);
}
