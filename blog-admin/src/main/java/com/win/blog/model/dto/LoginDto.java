package com.win.blog.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginDto {
  @NotBlank(message = "{admin.userName.not-blank}")
  @Size(min = 10, max = 12, message = "管理员账号长度为10~12")
  private String userName;
  @NotBlank(message = "{admin.password.not-blank}")
  private String password;
}
