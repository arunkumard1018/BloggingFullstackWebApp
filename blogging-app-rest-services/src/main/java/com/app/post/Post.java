package com.app.post;

import java.time.LocalDateTime;

import com.app.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "post_details")
public class Post {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String subHeading;
	@Column(columnDefinition = "TEXT")
	private String description;
	private LocalDateTime createdOn;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	public Post() {
	}
	public Post(Integer id, String title, String subHeading, String description, LocalDateTime createdOn) {
		super();
		this.id = id;
		this.title = title;
		this.subHeading = subHeading;
		this.description = description;
		this.createdOn = createdOn;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubHeading() {
		return subHeading;
	}

	public void setSubHeading(String subHeading) {
		this.subHeading = subHeading;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", subHeading=" + subHeading + ", description=" + description
				+ ", createdOn=" + createdOn + "]";
	}
	
	
	

}
