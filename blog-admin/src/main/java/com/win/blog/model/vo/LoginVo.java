package com.win.blog.model.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.win.blog.model.pojo.Admin;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginVo {

  private  String access_token;

  private String token_type;

  private String refresh_token;

  private String expires_in;

  private String scope;

  private Admin admin;
}
