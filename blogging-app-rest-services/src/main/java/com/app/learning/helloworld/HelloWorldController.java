package com.app.learning.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	/*Returning Hello World String */
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Welcome to Hello World Controller";
	}
	
	/*Returning Hello World bean */
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Aruna");
	}
	
	/** 
	 * understanding path parameters
	 *  example : /users/{userId}/todos/{todoId}  => /users/222/todos/5
	 *  
	 * */
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldUser(@PathVariable String name) {
		return new HelloWorldBean("Hello  " + name);
	}
	
	@GetMapping(path = "/")
	public String welcome() {
		String WelcomeText = "Welcome to Blogging Application Restful services";
        return "<h1 style='margin-top: 50px; text-align: center; color: green;'>" + WelcomeText + "</h1>";
    }
	
}
