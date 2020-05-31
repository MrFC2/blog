package com.win.blog.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.win.blog.enums.ResponseEnum;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVo<T> implements Serializable {
  private Integer status;
  private String msg;
  private T data;

  private ResponseVo(Integer status) {
    this.status = status;
  }

  private ResponseVo(Integer status, T data) {
    this.status = status;
    this.data = data;
  }
  private ResponseVo(Integer status, String msg) {
    this.status = status;
    this.msg = msg;
  }
  private ResponseVo(Integer status, String msg, T data) {
    this.status = status;
    this.msg = msg;
    this.data = data;
  }
  public Integer getStatus() {
    return status;
  }

  public String getMsg() {
    return msg;
  }

  public T getData() {
    return data;
  }

  // 操作是否成功
  @JsonIgnore
  public Boolean isSuccess() {
    return this.status == ResponseEnum.SUCCESS.getCode();
  }

  // 操作成功，返回状态code
  public static <T> ResponseVo<T> success() {
    return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode());
  }

  // 操作成功，返回状态code、msg
  public static <T> ResponseVo<T> successMsg(String msg) {
    return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), msg);
  }

  // 操作成功，返回code、data
  public static <T> ResponseVo<T> success(T data) {
    return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), data);
  }

  // 请求成功，返回code、msg、data
  public static <T> ResponseVo<T> success(String msg, T data) {
    return new ResponseVo<T>(ResponseEnum.SUCCESS.getCode(), msg, data);
  }

  // 操作失败，返回状态code
  public static <T> ResponseVo<T> error() {
    return new ResponseVo<T>(ResponseEnum.ERROR.getCode());
  }

  // 操作失败，返回状态code、msg
  public static <T> ResponseVo<T> errorMsg(String msg) {
    return new ResponseVo<T>(ResponseEnum.ERROR.getCode(), msg);
  }

  // 操作失败，返回code、data
  public static <T> ResponseVo<T> error(T data) {
    return new ResponseVo<T>(ResponseEnum.ERROR.getCode(), data);
  }

  // 操作失败，返回code、msg、data
  public static <T> ResponseVo<T> error(String msg, T data) {
    return new ResponseVo<T>(ResponseEnum.ERROR.getCode(), msg, data);
  }

  // 未登录，返回状态code、msg
  public static <T> ResponseVo<T> notLogin() {
    return new ResponseVo<T>(ResponseEnum.NOT_LOGIN.getCode(), ResponseEnum.NOT_LOGIN.getDesc());
  }

  // 服务器异常
  public static <T> ResponseVo<T> serverError() {
    return new ResponseVo<T>(ResponseEnum.SERVER_ERROR.getCode(), ResponseEnum.SERVER_ERROR.getDesc());
  }
}
