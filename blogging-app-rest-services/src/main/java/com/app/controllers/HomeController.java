package com.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping(path = "/")
	public String welcome() {
		String WelcomeText = "Welcome to Blogging Application Restful services";
        return "<h1 style='margin-top: 50px; text-align: center; color: green;'>" + WelcomeText + "</h1>";
    }
	
	
	/*Returning Hello World String */
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Welcome to Hello World Controller";
	}
	

	@GetMapping(path = "/hello-world/{name}")
	public HelloWorldBean helloWorldUser(@PathVariable String name) {
		return new HelloWorldBean("Hello  " + name);
	}
	
	@GetMapping(path = "/hello-world/")
	public HelloWorldBean helloWorldUser() {
		return new HelloWorldBean("Enter Your Name And Call the Api");
	}
	
}
record HelloWorldBean(String message) {}