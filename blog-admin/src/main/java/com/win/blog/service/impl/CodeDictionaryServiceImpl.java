package com.win.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.win.blog.mapper.CodeDictionaryMapper;
import com.win.blog.model.pojo.CodeDictionary;
import com.win.blog.service.CodeDictionaryService;
import org.springframework.stereotype.Service;

@Service
public class CodeDictionaryServiceImpl extends ServiceImpl<CodeDictionaryMapper, CodeDictionary> implements CodeDictionaryService {
}
