package com.stackSimplity.restServices.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackSimplity.restServices.Services.UserService;
import com.stackSimplity.restServices.entities.User;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	private List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@PostMapping("/users")
	private User createUser(@RequestBody User user) {
		return userService.createuser(user);
	}
	
	@GetMapping("/users/{id}")
	private Optional<User> getUserById(@PathVariable("id") Long id){
		return userService.getUserByLong(id);
	}
	
	@PutMapping("/users/{id}")
	private User updateUserById(@PathVariable("id") Long id,@RequestBody User user) {
		return userService.updateUserById(id, user);
	}
	
	@DeleteMapping("/users/{id}")
	private void deleteById(@PathVariable("id") Long id) {
		 userService.delete(id);
	}
	
	@GetMapping("/users/byUsername/{username}")
	private User getUserByUsername(@PathVariable("username") String username) {
		return userService.getUserByUserName(username);
	}
}
