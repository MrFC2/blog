package com.win.blog.model.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 7941177230303816507L;

    private String id;

    private String nickname;

    private String password;

    private String avatar;

    private String gender;

    private String phoneNumber;

    private String email;

    private String introduction;

    private Integer level;

    private Date registrationTime;

    private Date editTime;

    private boolean enabled;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

}
