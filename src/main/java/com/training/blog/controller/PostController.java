package com.training.blog.controller;

import com.training.blog.entity.Post;
import com.training.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/")
    public List<Post> getPosts(){
        return postService.getPost();
    }

    @GetMapping("/{slug}")
    public Post getPostBySlug(@PathVariable String slug){
        return postService.getPostBySlug(slug);
    }

    @PostMapping("/")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @PutMapping("/{slug}")
    public Post updatePost(@PathVariable String slug,@RequestBody Post sendByuser){
        return postService.updatePostBySlug(slug,sendByuser);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePostById(@PathVariable Integer id){
       return postService.deletePostById(id);
    }

    @PutMapping("/{id}/publish")
    public Post publishPost(@PathVariable Integer id){
        return postService.publishPost(id);
    }
}
