package com.win.blog.controller;

import com.win.blog.model.dto.LoginDto;
import com.win.blog.model.vo.ResponseVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/admin")
public class AdminController {

  @PostMapping("/login")
  public ResponseVo login(@Validated @NotNull(message = "不为空") String user) {
    return ResponseVo.success();
  }

  @GetMapping("/findPassword")
  public ResponseVo testDtoValidate(@Validated LoginDto dto) {
    return ResponseVo.success();
  }
}
