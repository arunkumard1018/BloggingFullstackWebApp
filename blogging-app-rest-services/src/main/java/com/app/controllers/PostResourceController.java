package com.app.controllers;

import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.app.entity.PostEntity;
import com.app.entity.UserDetailsEntity;
import com.app.exceptions.PostNotFoundException;
import com.app.exceptions.UserNotFoundException;
import com.app.model.Post;
import com.app.service.AuthenticationService;
import com.app.service.PostService;
import com.app.service.UserDetailsSevice;
import com.app.util.PostConverter;

@RestController
public class PostResourceController {

	private PostService postService;
	private UserDetailsSevice userDetailsSevice;
	private AuthenticationService authService;

	public PostResourceController(PostService postService, UserDetailsSevice userDetailsSevice,AuthenticationService authService) {
		this.postService = postService;
		this.userDetailsSevice = userDetailsSevice;
		this.authService = authService;
		
	}

	@GetMapping(path = "/posts")
	public List<Post> retriveAllPosts() {
		return postService.getAllPostsWithDetails();
	}

	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Post> CreatePost(@PathVariable Long id, @RequestBody Post post) {
		Optional<UserDetailsEntity> userDetails = userDetailsSevice.findById(id);
		
		
		if (userDetails.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		PostEntity savedPost = postService.savePost(post, userDetails.get());

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}")
				.buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping(path = "/users/{id}/posts")
	public List<Post> retriveAllPostsForUser(@PathVariable Long id) {
		Optional<UserDetailsEntity> userDetails = userDetailsSevice.findById(id);
		
		if (userDetails.isEmpty()) {
			throw new UserNotFoundException("id: " + id);
		}
		List<PostEntity> postEntities = userDetails.get().getPosts();
		return postEntities.stream().map(PostConverter::convertToPostDTO).collect(Collectors.toList());
	}

	
	@GetMapping(path = "/posts/{id}")
	public Post retrivePost(@PathVariable Long id) {
		Optional<PostEntity> post = postService.findById(id);
		if (post.isEmpty()) {
			throw new PostNotFoundException("postId : " + id);
		}
		return PostConverter.convertToPostDTO(post.get());
	}
	public String foo(@AuthenticationPrincipal User user) {
		return user.getUsername();
	}
	@RequestMapping("/foo")
	public String foo(Principal principal) {
		Authentication authentication = (Authentication) principal;
		User user = (User) authentication.getPrincipal();

		return "hello";
	}

//	

}
