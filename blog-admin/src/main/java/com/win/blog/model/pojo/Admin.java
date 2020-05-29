package com.win.blog.model.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class Admin implements UserDetails {
  private String id;
  private Integer type; // 0：超级管理员，1：普通管理员
  private String userName;
  @JsonIgnore
  private String password;
  private String email;
  private String phone;
  private String avatar;
  private String introduction;
  private String address;
  private boolean enabled;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private Date loginTime;
  private Date createTime;
  private Date editTime;


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @JsonIgnore
  @Override
  public String getUsername() {
    return userName;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isEnabled() {
    return enabled;
  }
}
