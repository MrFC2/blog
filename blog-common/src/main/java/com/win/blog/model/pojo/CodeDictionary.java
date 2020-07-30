package com.win.blog.model.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class CodeDictionary {

  private String id;

  private String parentId;

  private boolean isParent;

  private String code;

  private Integer sort;

  private String desc;

  private Date createTime;

  private Date editTime;

}
