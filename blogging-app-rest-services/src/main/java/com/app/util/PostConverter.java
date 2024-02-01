package com.app.util;

import com.app.entity.PostEntity;
import com.app.entity.UserDetailsEntity;
import com.app.model.Author;
import com.app.model.Post;

public class PostConverter {
	public static Post convertToPostDTO(PostEntity postEntity) {
		Post post = new Post();
		post.setId(postEntity.getId());
		post.setTitle(postEntity.getTitle());
		post.setDescription(postEntity.getDescription());
		post.setParagraph(postEntity.getParagraph());
		post.setImageUrl(postEntity.getImageUrl());
		post.setDate(postEntity.getDate());
		post.setTime(postEntity.getTime());

		UserDetailsEntity userDetails = postEntity.getUserDetails();
		if (userDetails != null) {
			Author author = new Author(userDetails.getName(), userDetails.getId(),
					userDetails.getUserProfileImageUrl());
			post.setAuthor(author);
		}

		return post;
	}
}
