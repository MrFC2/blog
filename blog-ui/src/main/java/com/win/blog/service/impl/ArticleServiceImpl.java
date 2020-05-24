package com.win.blog.service.impl;

import com.win.blog.mapper.ArticleMapper;
import com.win.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;


    @Override
    public int add(Object pojo) {
        return articleMapper.insert(pojo);
    }

    @Override
    public int drop(Object pojo) {
        return articleMapper.delete(pojo);
    }

    @Override
    public int modify(Object pojo) {
        return articleMapper.update(pojo);
    }

    @Override
    public Object find(Object pojo) {
        return articleMapper.select(pojo);
    }
}
