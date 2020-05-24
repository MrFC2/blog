package com.win.blog.service.impl;

import com.win.blog.mapper.UserMapper;
import com.win.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int add(Object pojo) {
        return userMapper.insert(pojo);
    }

    @Override
    public int drop(Object pojo) {
        return userMapper.delete(pojo);
    }

    @Override
    public int modify(Object pojo) {
        return userMapper.update(pojo);
    }

    @Override
    public Object find(Object pojo) {
        return userMapper.select(pojo);
    }
}
