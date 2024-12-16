package com.training.blog.repository;

import com.training.blog.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends CrudRepository<Post,Integer> {
    //Optional<Post> findBySlug(String slug);
    Optional<Post> findFirstBySlug(String slug);
}
