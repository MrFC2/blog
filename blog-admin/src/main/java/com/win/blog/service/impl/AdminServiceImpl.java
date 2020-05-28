package com.win.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.win.blog.mapper.AdminMapper;
import com.win.blog.model.pojo.Admin;
import com.win.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
  @Autowired
  private AdminMapper adminMapper;

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    QueryWrapper<Admin> wrapper = new QueryWrapper<>();
    wrapper.eq("user_name", userName);
    Admin admin = adminMapper.selectOne(wrapper);
    if (admin == null) {
      throw new UsernameNotFoundException("用户不存在");
    }
    return admin;
  }
}
