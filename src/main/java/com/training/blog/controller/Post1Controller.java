package com.training.blog.controller;

import com.training.blog.entity.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Post1Controller {

//    Post post1 = new Post(1,"title1","title1");
//    Post post2 = new Post(2,"test2","test2");
//    //List<Post> posts = List.of(post1,post2);
//    List<Post> posts = new ArrayList<Post>(Arrays.asList(post1,post2));
//
//    @GetMapping("/")
//    public List<Post> getPosts(){
//        return posts;
//    }
//
//    @GetMapping("/{slug}")
//    public Post getPostBySlug(@PathVariable String slug){
//        return posts.stream().filter(post -> post.getSlug().equals(slug)).findFirst().orElse(null);
//    }
//
//    @PostMapping("/")
//    public Post createPost(@RequestBody Post post){
//        posts.add(post);
//        return post;
//    }
//
//    @PutMapping("/{slug}")
//    public Post updatePost(@PathVariable String slug,@RequestBody Post sendByuser){
//        Post savePost = posts.stream().filter(p -> p.getSlug().equals(slug)).findFirst().orElse(null);
//        if (savePost == null){
//            return null;
//        }
//        posts.remove(savePost);
//        savePost.setTitle(sendByuser.getTitle());
//        savePost.setSlug(sendByuser.getSlug());
//        posts.add(savePost);
//        return savePost;
//    }
//
//    @DeleteMapping("/{id}")
//    public Boolean deletePostById(@PathVariable Integer id){
//        Post savePost = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
//        if (savePost == null){
//            return false;
//        }
//        posts.remove(savePost);
//        return true;
//    }
//
//    @PutMapping("/{id}/publish")
//    public Post publishPost(@PathVariable Integer id){
//        Post savePost = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
//        if (savePost == null){
//            return null;
//        }
//        savePost.setPublished(true);
//        return savePost;
//    }
}
