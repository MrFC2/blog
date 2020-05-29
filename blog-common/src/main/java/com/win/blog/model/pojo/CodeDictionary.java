package com.win.blog.model.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class CodeDictionary {

  private String id;

  private String parentId;

  private String name;

  private Integer sort;

  private String desc;

  private Date createTime;

  private Date editTime;

}
