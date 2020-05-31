package com.win.blog.enums;

public enum  ResponseEnum {
  SUCCESS (200,"操作成功"),
  ERROR(400, "操作失败"),
  SERVER_ERROR(500, "服务器错误"),
  NOT_LOGIN(100, "用户未登录"),
  LOGIN_EXPIRED(104, "登录过期");
  private final Integer code;
  private final String desc;
  private ResponseEnum(Integer code, String desc){
    this.code = code;
    this.desc = desc;
  }

  public Integer getCode() {
    return this.code;
  }
  public String getDesc() {
    return this.desc;
  }
}
