package com.win.blog.serviceTest;

import com.win.blog.model.pojo.User;
import com.win.blog.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userServiceTest() {
        User user = new User();

        user.setId("2");
        Object object = userService.find(user);
        System.out.println(object);

        //user.setId("1");
        //user.setEmail("2584221963@qq.com");
        //int result = userService.modify(user);
        //System.out.println(result);

        //user.setId("3");
        //int result = userService.drop(user);
        //System.out.println(result);

        //user.setId("3");
        //user.setNickname("fc");
        //user.setGender("男");
        //user.setPhoneNumber("13535921507");
        //user.setEmail("2584221963@qq.com");
        //user.setIntroduction("handsome");
        //user.setLevel(1);
        //int result = userService.add(user);
        //System.out.println(result);
    }

}
