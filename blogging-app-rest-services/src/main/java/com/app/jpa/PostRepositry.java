package com.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.post.Post;

public interface PostRepositry extends JpaRepository<Post, Integer>{

}
