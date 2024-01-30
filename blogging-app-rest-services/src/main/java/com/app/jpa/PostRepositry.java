package com.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Post;

public interface PostRepositry extends JpaRepository<Post, Integer>{

}
