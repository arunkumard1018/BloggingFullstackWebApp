package com.app.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.Comment;

public interface CommentRepositry extends JpaRepository<Comment, Long> {

}
