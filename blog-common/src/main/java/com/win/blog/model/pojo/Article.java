package com.win.blog.model.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Article implements Serializable {

    private static final long serialVersionUID = -1697052109639548827L;

    private String id;

    private String parentId;

    private String userId;

    private Integer type;

    private String title;

    private String content;

    private String summary;

    private Integer readAmount;

    private String imageSrc;

    private boolean isPublish;

    private boolean isOpen;

    private Date publishTime;

    private Date editTime;

    private List categoryList;

}
