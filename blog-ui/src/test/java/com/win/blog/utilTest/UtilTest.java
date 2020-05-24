package com.win.blog.utilTest;

import com.win.blog.util.EmailUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilTest {

    @Autowired
    private EmailUtil emailUtil;

    @Test
    public void EmailUtilTest() {
        emailUtil.sendEmailVerifyCode("2584221963@qq.com", "1299276001@qq.com", "测试发送邮箱验证码", "12345");
    }
}
