package com.training.blog.controller;

import com.training.blog.entity.Comment;
import com.training.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public Iterable<Comment> getComments(
            @RequestParam(required = false) String postSlug,
            @RequestParam(required = false) Integer pageNno,
            @RequestParam(required = false) Integer limit
    ){
        return commentService.getComments(postSlug,pageNno,limit);
    }

    @GetMapping("/{id}")
    public Comment getComment(@PathVariable Integer id){
       return commentService.getComment(id);
    }

    @PostMapping
    public Comment postComment(@RequestBody Comment comment){
        return commentService.postComment(comment);
    }
}
