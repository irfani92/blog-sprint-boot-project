package com.training.blog.mapper;

import com.training.blog.entity.Post;
import com.training.blog.request.post.CreatePostRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);
    Post map(CreatePostRequest postRequest);
}
