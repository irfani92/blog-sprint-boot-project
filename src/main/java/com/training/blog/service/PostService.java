package com.training.blog.service;

import com.training.blog.entity.Post;
import com.training.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Iterable<Post> getPost() {
        return postRepository.findAll();
    }

    public Post getPostBySlug(String slug){
        return postRepository.findFirstBySlug(slug).orElse(null);
    }

    public Post createPost(Post post){
        post.setCreatedAt(Instant.now().getEpochSecond());
        return postRepository.save(post);
    }

    public Post updatePostBySlug(String slug, Post sendByuser){
        Post savePost = postRepository.findFirstBySlug(slug).orElse(null);
        if (savePost == null){
            return null;
        }
        sendByuser.setId(savePost.getId());
        return postRepository.save(sendByuser);
    }

    public Boolean deletePostById(Integer id){
        Post savePost = postRepository.findById(id).orElse(null);
        if (savePost == null){
            return false;
        }
        postRepository.deleteById(id);
        return true;
    }

    public Post publishPost(Integer id){
        Post savePost = postRepository.findById(id).orElse(null);
        if (savePost == null){
            return null;
        }
        savePost.setPublished(true);
        savePost.setPublishedAt(Instant.now().getEpochSecond());
        return postRepository.save(savePost);
    }
}
