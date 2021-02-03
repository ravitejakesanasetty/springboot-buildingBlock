package com.stackSimplity.restServices.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import com.stackSimplity.restServices.Exception.UserExistException;
import com.stackSimplity.restServices.Exception.UserNotFoundException;
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
	private ResponseEntity<Void> createUser(@RequestBody User user,UriComponentsBuilder builder) {
		try {
			 userService.createuser(user);
			 HttpHeaders header =new HttpHeaders();
			 header.setLocation(builder.path("/users/{id}").buildAndExpand(user.getId()).toUri());
			 return new ResponseEntity<Void>(header,HttpStatus.CREATED);
		} catch (UserExistException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
			}
	}
	
	@GetMapping("/users/{id}")
	private Optional<User> getUserById(@PathVariable("id") Long id){
		try {
			return userService.getUserByLong(id);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
	}
	
	@PutMapping("/users/{id}")
	private User updateUserById(@PathVariable("id") Long id,@RequestBody User user) {
		try {
			return userService.updateUserById(id, user);
		} catch (UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
			}
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
