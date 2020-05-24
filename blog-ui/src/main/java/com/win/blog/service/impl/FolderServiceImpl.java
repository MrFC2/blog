package com.win.blog.service.impl;

import com.win.blog.mapper.FolderMapper;
import com.win.blog.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private FolderMapper folderMapper;

    @Override
    public int add(Object pojo) {
        return folderMapper.insert(pojo);
    }

    @Override
    public int drop(Object pojo) {
        return folderMapper.delete(pojo);
    }

    @Override
    public int modify(Object pojo) {
        return folderMapper.update(pojo);
    }

    @Override
    public Object find(Object pojo) {
        return folderMapper.select(pojo);
    }
}
