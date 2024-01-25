package com.app.post;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.exceptions.PostNotFoundException;
import com.app.exceptions.UserNotFoundException;
import com.app.user.User;
import com.app.user.UserDaoService;

@RestController
public class PostResource {
	private UserDaoService userService;
	private PostDaoService postService;
	public PostResource(UserDaoService userService, PostDaoService postService) {
		super();
		this.userService = userService;
		this.postService = postService;
	}
	
	@GetMapping(path = "/posts")
	public List<Post> retriveAllPosts(){
		return postService.retriveAllPosts();
	}
	
	@GetMapping(path = "/users/{id}/posts")
	public List<Post> retriveAllPostsForUser(@PathVariable Integer id){
		Optional<User> user = userService.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		return user.get().getPosts();
	}
	
	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Post> CreatePost(@PathVariable Integer id, @RequestBody Post post) {
		Optional<User> user = userService.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		post.setUser(user.get());
		Post savedPost = postService.savePost(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedPost.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(path = "/users/{id}/posts/{postId}")
	public Post retrivePostForUser(@PathVariable Integer id, @PathVariable Integer postId){
		Optional<User> user = userService.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("id : " + id);
		}
		Optional<Post> post = postService.findById(postId);
		if(post.isEmpty()) {
			throw new PostNotFoundException("postId : "+postId);
		}
		return post.get();
	}
	
	@GetMapping(path = "/posts/{id}")
	public Post retrivePost(@PathVariable Integer id) {
		Optional<Post> post = postService.findById(id);
		if(post.isEmpty()) {
			throw new PostNotFoundException("postId : "+id);
		}
		return post.get();
	}
	

}
