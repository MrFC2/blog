package com.win.blog.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmailVerifyCode(String from, String to, String subJect, String verifyCode) {
        //创建发送邮箱对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //发送人
        mailMessage.setFrom(from);
        //收件人
        mailMessage.setTo(to);
        //邮件标题
        mailMessage.setSubject(subJect);
        //邮件内容（验证码）
        mailMessage.setText(verifyCode);
        //发送
        mailSender.send(mailMessage);
    }
}
