package com.app.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.aws.AmzonClientService;
import com.app.entity.PostEntity;
import com.app.entity.UserDetailsEntity;
import com.app.exceptions.PostNotFoundException;
import com.app.exceptions.UserNotFoundException;
import com.app.model.Post;
import com.app.service.AuthenticationService;
import com.app.service.PostService;
import com.app.service.UserDetailsSevice;
import com.app.util.ImageUrl;
import com.app.util.PostConverter;

@RestController
public class PostResourceController {

    private PostService postService;
    private UserDetailsSevice userDetailsSevice;
    private AuthenticationService authService;
    private AmzonClientService amzonClientService;

    public PostResourceController(PostService postService, UserDetailsSevice userDetailsSevice,
			AuthenticationService authService, AmzonClientService amzonClientService) {
		super();
		this.postService = postService;
		this.userDetailsSevice = userDetailsSevice;
		this.authService = authService;
		this.amzonClientService = amzonClientService;
	}

	@GetMapping(path = "/posts")
    public List<Post> retriveAllPosts() {
        return postService.getAllPostsWithDetails();
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Post> CreatePost(@PathVariable Long id, @RequestBody Post post) {
    	if (authService.isAuthenticatedUser(id)) {
            Optional<UserDetailsEntity> userDetails = userDetailsSevice.findById(id);
            if (userDetails.isEmpty()) {
                throw new UserNotFoundException("id: " + id);
            }
            MultipartFile file = post.getFile();
            String UploadedFileUrl = amzonClientService.uploadBlogPostImage(file,id);
			if (UploadedFileUrl == null) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
            post.setImageUrl(UploadedFileUrl);
            PostEntity savedPost = postService.savePost(post, userDetails.get());
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{post_id}")
                    .buildAndExpand(savedPost.getId()).toUri();
            return ResponseEntity.created(location).build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
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

    @DeleteMapping("/users/{id}/posts/{postId}")
    public ResponseEntity<String> deletePost(@PathVariable Long id, @PathVariable long postId) {
        if (authService.isAuthenticatedUser(id)) {
            Optional<PostEntity> post = postService.findById(postId);
            if (post.isEmpty()) throw new PostNotFoundException("Post Not Found : " + postId);

            if (post.get().getUserDetails().getId() == id) {
                postService.deletePostById(postId);
                return ResponseEntity.status(HttpStatus.OK).body("deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authorized ");
    }
    
    @PutMapping("/users/{id}/posts")
    public ResponseEntity<String> UpdatePost(@PathVariable Long id, @RequestBody Post post) {
        if (authService.isAuthenticatedUser(id)) {
            Optional<PostEntity> postEntity = postService.findById(post.getId());
            if (postEntity.isEmpty()) throw new PostNotFoundException("Post Not Found : " + post.getId());
            if (postEntity.get().getUserDetails().getId() == id) {
                Optional<UserDetailsEntity> userDetails = userDetailsSevice.findById(id);
                if(userDetails.isEmpty()) throw new UserNotFoundException("user id : "+id);
                postService.updatePost(post,postEntity.get(),userDetails.get());
                return ResponseEntity.status(HttpStatus.OK).body("deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Not Authorized ");
    }
    
    @GetMapping("/posts/page/{page}/size/{size}")
    public Page<PostEntity> recentPosts(@PathVariable int page,@PathVariable int size){
    	Page<PostEntity> recentPosts = postService.getRecentPosts(page, size);
    	if(recentPosts.isEmpty()) throw new PostNotFoundException("No Posts");
    	return recentPosts;
    }
    
}
