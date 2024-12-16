package com.training.blog.entity;

import lombok.Data;

@Data
public class Post {
    private Integer id;
    private String title;
    private String body;
    private String slug;
    private boolean isPublished;
    private boolean isDeleted;
    private boolean createdAt;
    private boolean publishedAt;
//
    public Post(Integer id, String title, String slug) {
        this.id = id;
        this.title = title;
        this.slug = slug;
    }
}
