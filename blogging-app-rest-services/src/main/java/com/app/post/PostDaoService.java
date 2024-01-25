package com.app.post;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.jpa.PostRepositry;

@Service
public class PostDaoService {
	
	private PostRepositry postRepositry;
	public PostDaoService(PostRepositry postRepositry) {
		super();
		this.postRepositry = postRepositry;
	}

	public List<Post> retriveAllPosts() {
		return postRepositry.findAll();
	}

	public Post savePost(Post post) {
		post.setCreatedOn(LocalDateTime.now());
		return postRepositry.save(post);
	}

	public Optional<Post> findById(Integer postId) {
		return postRepositry.findById(postId);
	}
	

}
