package com.win.blog.model.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class SystemResources {

  private String id;

  private String url;

  private String categoryId;

  private Integer sort;

  private String desc;

  private Date uploadTime;

  private Date editTime;
}
