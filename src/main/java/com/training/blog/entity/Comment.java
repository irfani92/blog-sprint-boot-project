package com.training.blog.entity;

import lombok.Data;

@Data
public class Comment {
    private Integer id;
    private String name;
    private String email;
    private String body;
    private Long createdAt;
}
