package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.exceptions.PostNotFoundException;
import com.app.jpa.PostRepositry;
import com.app.model.Comment;
import com.app.model.Post;

@Service
public class PostService {
	
	private PostRepositry postRepositry;
	public PostService(PostRepositry postRepositry) {
		super();
		this.postRepositry = postRepositry;
	}

	public List<Post> retriveAllPosts() {
		return postRepositry.findAll();
	}

	public Post savePost(Post post) {
		post.setDate(LocalDate.now());
		return postRepositry.save(post);
	}

	public Optional<Post> findById(Integer postId) {
		return postRepositry.findById(postId);
	}

	public List<Comment> retriveCommentsForPost(Integer post_id) {
		Optional<Post> post = postRepositry.findById(post_id);
		if(post.isEmpty()) {
			throw new PostNotFoundException("post id: "+ post_id);
		}
		return post.get().getComments();
	}
	

}
