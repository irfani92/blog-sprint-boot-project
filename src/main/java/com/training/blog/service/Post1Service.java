package com.training.blog.service;

import com.training.blog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Service
//@AllArgsConstructor
//@NoArgsConstructor
public class Post1Service {
//    Post post1 = new Post(1,"title1","title1");
//    Post post2 = new Post(2,"test2","test2");
//    //List<Post> posts = List.of(post1,post2);
//    List<Post> posts = new ArrayList<Post>(Arrays.asList(post1,post2));
//
//    public List<Post> getPost() {
//        return posts;
//    }
//
//    public Post getPostBySlug(String slug){
//        return posts.stream().filter(post -> post.getSlug().equals(slug)).findFirst().orElse(null);
//    }
//
//    public Post createPost(Post post){
//        posts.add(post);
//        return post;
//    }
//
//    public Post updatePostBySlug(String slug, Post sendByuser){
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
//    public Boolean deletePostById(Integer id){
//        Post savePost = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
//        if (savePost == null){
//            return false;
//        }
//        posts.remove(savePost);
//        return true;
//    }
//
//    public Post publishPost(Integer id){
//        Post savePost = posts.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
//        if (savePost == null){
//            return null;
//        }
//        savePost.setPublished(true);
//        return savePost;
//    }
}
