package com.win.blog.model.dto.admin;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginDTO {
  @NotBlank(message = "{admin.userName.not-blank}")
  private String userName;
  @NotBlank(message = "{admin.password.not-blank}")
  private String password;
}
