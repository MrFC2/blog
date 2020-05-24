package com.win.blog.service.impl;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    //TODO 可将Dao层接口注入进来，通过前台传入的用户名或其他信息去查询数据库中对应的密码是否正确

    //注入SpringSecurity自带的密码加密类，用于测试。
    //实际上是应该在用户注册时候注入使用，使用encode方法将明文密码加密，再保存到数据库中。
    //@Autowired
    //private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(username);
        //System.out.println(passwordEncoder.encode("123"));

        //TODO 根据用户名，查找到对应的密码与权限

        //封装用户信息，并返回。参数分别是：用户名，密码，用户权限（这里使用admin）
        return new User(username, "123", AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
