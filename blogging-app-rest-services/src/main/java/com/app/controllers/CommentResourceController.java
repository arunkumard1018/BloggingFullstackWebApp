package com.app.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.exceptions.PostNotFoundException;
import com.app.exceptions.UserNotFoundException;
import com.app.model.Comment;
import com.app.model.Post;
import com.app.model.UserDetails;
import com.app.service.CommentService;
import com.app.service.PostService;
import com.app.service.UserService;

@RestController
public class CommentResourceController {

	private PostService postService;
	private UserService userService;
	private CommentService commentService;
	

	public CommentResourceController(PostService postService, UserService userService, CommentService commentService) {
		super();
		this.postService = postService;
		this.userService = userService;
		this.commentService = commentService;
	}

	@GetMapping(path = "/posts/{post_id}/comments")
	public List<Comment> retriveComments(@PathVariable Integer post_id) {
		return postService.retriveCommentsForPost(post_id);
	}

	@PostMapping(path = "/posts/{post_id}/comments/{user_id}")
	public List<Comment> createComments(@RequestBody Comment comment, @PathVariable Integer post_id,
			@PathVariable Integer user_id) {
		
		Optional<UserDetails> user = userService.findById(user_id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User Not found for id: " + user_id);
		}
		comment.setUser(user.get());
		Optional<Post> post = postService.findById(post_id);
		if (post.isEmpty()) {
			throw new PostNotFoundException("post Not found for postId : " + post_id);
		}
		comment.setPost(post.get());
		commentService.save(comment);
		return postService.retriveCommentsForPost(post_id);
	}
	
}
