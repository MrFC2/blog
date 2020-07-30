package com.win.blog.model.dto.admin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class CreateDTO {

  @NotNull(message = "{admin.type.not-null}")
  @Pattern(regexp = "[01]", message = "{admin.type.pattern}")
  private Integer type; // 0：超级管理员，1：普通管理员

  @NotBlank(message = "{admin.userName.not-blank}")
  @Size(max = 32, message = "{admin.userName.max-size}" )
  private String userName;

  @NotBlank(message = "{admin.password.not-blank}")
  private String password;

  @NotBlank(message = "{admin.email.not-blank}")
  @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$", message = "{eamil.pattern}")
  private String email;

  @NotBlank(message = "{admin.phone.not-blank}")
  @Pattern(regexp = "^1[3456789]\\d{9}$", message = "{phone.pattern}")
  private String phone;

  @Size(max = 128, message = "{admin.introduction.max-size}")
  private String introduction;

  @Size(max = 128, message = "{admin.address.max-size}")
  private String address;

  @NotNull(message = "{admin.enabled.not-null}")
  private boolean enabled;

  @NotNull(message = "{admin.accountNonExpired.not-null}")
  private boolean accountNonExpired;

  @NotNull(message = "{admin.accountNonLocked.not-null}")
  private boolean accountNonLocked;
}
