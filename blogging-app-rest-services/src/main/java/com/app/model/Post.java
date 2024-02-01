package com.app.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Post {
	
	private Long id;
	
	private String title;
	
	private String description;
	
	private String paragraph;
	
	private String imageUrl;
	
	private LocalDate date;
	
	private LocalTime time;
	
	private Author author;
	
	
	

	
	public Post(Long id, String title, String description, String paragraph, String imageUrl, LocalDate date,
			LocalTime time, Author author) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.paragraph = paragraph;
		this.imageUrl = imageUrl;
		this.date = date;
		this.time = time;
		this.author = author;
	}
	

	public Post() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getParagraph() {
		return paragraph;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	

	
}
