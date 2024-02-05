package com.app.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.app.exceptions.PostNotFoundException;
import com.app.exceptions.UserNotFoundException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.app.entity.PostEntity;
import com.app.entity.UserDetailsEntity;
import com.app.entity.UserEntity;
import com.app.jpa.PostRepository;
import com.app.model.Author;
import com.app.model.Post;
import com.app.util.PostConverter;

import ch.qos.logback.core.pattern.Converter;

@Service
public class PostService {
	
	private PostRepository postRepository;
	public PostService(PostRepository postRepositry) {
		super();
		this.postRepository = postRepositry;
	}

	public List<PostEntity> retriveAllPosts() {
		return postRepository.findAll();
	}

	public PostEntity savePost(Post post,UserDetailsEntity userDetails) {
		PostEntity postEntity = new PostEntity();
		postEntity.setTitle(post.getTitle());
		postEntity.setDescription(post.getDescription());
		postEntity.setParagraph(post.getParagraph());
		postEntity.setImageUrl(post.getImageUrl());
		postEntity.setDate(LocalDate.now());
		postEntity.setTime(LocalTime.now());
		postEntity.setImageUrl(post.getImageUrl());
		postEntity.setUserDetails(userDetails);
		return postRepository.save(postEntity);
	}
	
	public List<Post> getAllPostsWithDetails() {
        List<PostEntity> postEntities = postRepository.findAll();
        return postEntities.stream()
                .map(PostConverter :: convertToPostDTO)
                .collect(Collectors.toList());
    }

	public Optional<PostEntity> findById(Long id) {
		return postRepository.findById(id);
	}

	public void deletePostById(Long id) {
		postRepository.deleteById(id);
	}

	public void updatePost(Post post, PostEntity postEntity,UserDetailsEntity userDetails) {
		postRepository.delete(postEntity);
		savePost(post,userDetails);
	}
	
	public Page<PostEntity> getRecentPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<PostEntity> recentPosts = postRepository.findAllByOrderByDateDescTimeDesc(pageable);
        return recentPosts;
        
    }
	
	
}
