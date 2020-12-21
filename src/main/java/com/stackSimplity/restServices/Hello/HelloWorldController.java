package com.stackSimplity.restServices.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/helloWorld")
	public String helloWorld() {
		return "HelloWorld";
	}
	
	@GetMapping("/helloworldbean")
	public userDetails helloworldbean() {
		return new userDetails("ravi","teja","hyderabad");
	}
}
