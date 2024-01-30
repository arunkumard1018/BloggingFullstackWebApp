package com.app.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.app.jpa.CommentRepositry;
import com.app.model.Comment;

@Service
public class CommentService {

	CommentRepositry commentRepositry;
	
	public CommentService(CommentRepositry commentRepositry) {
		super();
		this.commentRepositry = commentRepositry;
	}

	public void save(Comment comment) {
		comment.setCreatedAt(LocalDateTime.now());
		commentRepositry.save(comment);
		
	}

}
