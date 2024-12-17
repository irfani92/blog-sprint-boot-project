package com.training.blog.service;

import com.training.blog.entity.Post;
import com.training.blog.mapper.PostMapper;
import com.training.blog.repository.PostRepository;
import com.training.blog.request.post.CreatePostRequest;
import com.training.blog.response.CreatePostResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class PostService {

    @Autowired
    PostRepository postRepository;

    public Iterable<Post> getPost() {
        //return postRepository.findAll();
        return postRepository.findByIsDeleted(false);
    }

    public Post getPostBySlug(String slug){
        return postRepository.findFirstBySlugAndIsDeleted(slug, false).orElse(null);
    }

    public CreatePostResponse createPost(CreatePostRequest request){
//        Post post = new Post();
//        post.setTitle(request.getTitle());
//        post.setBody(request.getBody());
//        post.setSlug(request.getSlug());
        Post post = PostMapper.INSTANCE.map(request);
        post.setCommentCount(0L);
        post.setCreatedAt(Instant.now().getEpochSecond());
        post = postRepository.save(post);

        return CreatePostResponse.builder()
                .slug(post.getSlug())
                .body(post.getBody())
                .title(post.getTitle())
                .commentCount(post.getCommentCount())
                .build();
    }

    public Post updatePostBySlug(String slug, Post sendByuser){
        Post savePost = postRepository.findFirstBySlugAndIsDeleted(slug, false).orElse(null);
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
       // postRepository.deleteById(id);
        savePost.setDeleted(true);
        postRepository.save(savePost);
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
