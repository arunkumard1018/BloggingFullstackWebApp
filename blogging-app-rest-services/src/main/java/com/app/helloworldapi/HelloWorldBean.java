package com.app.helloworldapi;


public class HelloWorldBean {

	private String message;
	
	public HelloWorldBean(String message) {
		super();
		this.message = message;
	}

	public String getName() {
		return message;
	}

	public void setName(String name) {
		this.message = name;
	}
	
}
