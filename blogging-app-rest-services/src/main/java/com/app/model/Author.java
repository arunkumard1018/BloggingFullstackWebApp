package com.app.model;

public class Author {
	private String name;
    private Long id;
    private String authImageUrl;
    
    
	public Author(String name, Long id, String authImageUrl) {
		this.name = name;
		this.id = id;
		this.authImageUrl = authImageUrl;
	}
	
	public Author() {
		super();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAuthImageUrl() {
		return authImageUrl;
	}
	public void setAuthImageUrl(String authImageUrl) {
		this.authImageUrl = authImageUrl;
	}
    
    
}
