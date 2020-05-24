package com.win.blog.config;

import com.win.blog.handler.MyAuthenticationFailureHandler;
import com.win.blog.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //使用表单形式登录界面
                .formLogin()
                //指定用户访问项目，需要身份验证时，显示的登录页面或跳转的请求
                .loginPage("/security/requireAuthority")
                //指定要通过认证的表单提交路径
                .loginProcessingUrl("/login")
                //使用自定义的成功登录处理器
                .successHandler(new MyAuthenticationSuccessHandler())
                //使用自定义的失败登录处理器
                .failureHandler(new MyAuthenticationFailureHandler())
                .and()
                //配置请求授权
                .authorizeRequests()
                //匹配不需要身份认证的路径：
                //1.身份认证请求 2.登录页请求
                .antMatchers("/security/requireAuthority", "/login").permitAll()
                //除以上匹配的不需要身份认证的请求之外，其他所有请求
                .anyRequest()
                //都需要通过认证
                .authenticated()
                .and()
                .csrf().disable();
    }

    //因为Spring boot 2.0.3引用的security 依赖是 spring security 5.X版本，此版本需要提供一个PasswordEncorder的实例，否则后台汇报错误：
    //初始化SpringSecurity自带的密码加密类
    //查看BCryptPasswordEncoder类的源码可发现，其中有encode和matches方法。
    //encode方法提供给开发者调用，常用于用户注册，将明文密码加密，后保存进数据库中
    //matches方法是SpringSecurity自动调用。当进入默认登录页，输入账号密码后，将会拿页面输入的明文密码和数据库读取出来后解密过后的密码匹配
    //@Bean
    //public PasswordEncoder passwordEncoder() {
    //    return new BCryptPasswordEncoder();
    //}

    //因为Spring boot 2.0.3引用的security 依赖是 spring security 5.X版本，此版本需要提供一个PasswordEncorder的实例，否则后台汇报错误：
    //此处初始化的bean作用，意味着在UserDetailService中loadUserByUsername不需要再传入加密密码，使用明文即可。
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}
