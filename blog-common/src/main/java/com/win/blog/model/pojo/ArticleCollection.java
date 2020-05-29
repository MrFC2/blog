package com.win.blog.model.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class ArticleCollection implements Serializable {

    private static final long serialVersionUID = -8262389544285907907L;

    private String id;

    private String parentId;

    private String name;

    private String userId;

    private Date createTime;

    private Date editTime;

}
