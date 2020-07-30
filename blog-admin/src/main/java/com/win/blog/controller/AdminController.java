package com.win.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.win.blog.model.dto.admin.LoginDTO;
import com.win.blog.model.pojo.Admin;
import com.win.blog.model.vo.LoginVo;
import com.win.blog.model.vo.ResponseVo;
import com.win.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {

  @Autowired
  AdminService adminService;

  @GetMapping("/checkAdminIsExist")
  public boolean checkAminIsExist(@NotNull(message = "{admin.userName.not-blank}") String name) {
    QueryWrapper<Admin> wrapper = new QueryWrapper<>();
    wrapper.eq("user_name", name);
    return adminService.getOne(wrapper) != null;
  }

  @PostMapping("/login")
  public ResponseVo login(@Validated LoginDTO dto, HttpServletRequest request) {
    String url = "http://localhost:" + request.getLocalPort() + request.getContextPath() + "/oauth/token";
    RestTemplate template = new RestTemplate();
    MultiValueMap<String, String> reqMap= new LinkedMultiValueMap<>();
    reqMap.add("username", dto.getUserName());
    reqMap.add("password", dto.getPassword());
    reqMap.add("grant_type", "password");
    reqMap.add("client_id", "password");
    reqMap.add("scope", "all");
    reqMap.add("client_secret", "123456");
    LoginVo lvo = new LoginVo();
    try {
      lvo = template.postForObject(url, reqMap, LoginVo.class);
    } catch (Exception e) {
      return ResponseVo.errorMsg("账号密码错误");
    }
    QueryWrapper<Admin> wrapper = new QueryWrapper<>();
    wrapper.eq("user_name", dto.getUserName());
    wrapper.eq("password", dto.getPassword());
    lvo.setAdmin(adminService.getOne(wrapper));
    return ResponseVo.success(lvo);
  }

  @GetMapping("/findPassword")
  public ResponseVo testDtoValidate(@Validated LoginDTO dto) {
    return ResponseVo.success();
  }

  @GetMapping("/logout")
  public String testLogout() {
    return "退出系统成功";
  }

  // @PostMapping("/create")0
  // public

}
