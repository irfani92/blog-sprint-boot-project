package com.training.blog.controller;

import com.training.blog.entity.Post;
import com.training.blog.request.post.CreatePostRequest;
import com.training.blog.response.CreatePostResponse;
import com.training.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public Iterable<Post> getPosts(){
        return postService.getPost();
    }

    @GetMapping("/{slug}")
    public Post getPostBySlug(@PathVariable String slug){
        return postService.getPostBySlug(slug);
    }

    @PostMapping
    public CreatePostResponse createPost(@Valid @RequestBody CreatePostRequest createPostRequest){
        return postService.createPost(createPostRequest);
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
