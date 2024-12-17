package com.training.blog.service;

import com.training.blog.entity.Comment;
import com.training.blog.entity.Post;
import com.training.blog.repository.CommentRepository;
import com.training.blog.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    public Iterable<Comment> getComments(
            String postSlug,
            Integer pageNo,
            Integer limit
    ){
        Post post = postRepository.findFirstBySlugAndIsDeleted(postSlug, false).orElse(null);
        if (post == null){
            return  null;
        }
        PageRequest pageRequest =PageRequest.of(pageNo,limit);
       return commentRepository.findByPostId(post.getId(),pageRequest).getContent();
    }

    public Comment getComment(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Transactional
    public Comment postComment(Comment comment){
        Post post = postRepository.findFirstBySlugAndIsDeleted(comment.getPost().getSlug(), false).orElse(null);
        if(post == null){
            return null;
        }

        comment.setCreatedAt(Instant.now().getEpochSecond());
        comment.getPost().setId(post.getId());
        comment = commentRepository.save(comment);

        post.setCommentCount(post.getCommentCount() + 1);
        postRepository.save(post);

        return comment;
    }
}
