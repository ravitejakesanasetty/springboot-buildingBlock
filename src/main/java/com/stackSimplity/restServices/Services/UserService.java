package com.stackSimplity.restServices.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.stackSimplity.restServices.Exception.UserExistException;
import com.stackSimplity.restServices.Exception.UserNotFoundException;
import com.stackSimplity.restServices.Repostiory.UserRepository;
import com.stackSimplity.restServices.entities.User;



@Service
public class UserService {
    @Autowired
	private UserRepository userRepository;
    
    
    public List<User> getAllUser(){
    	return userRepository.findAll();
    }
    
    public User createuser(User user) throws UserExistException
    {
    	User existingUser=userRepository.findByUsername(user.getUsername());
    	if(existingUser!=null) {
    		throw new UserExistException("User already exists");
    	}
    	return userRepository.save(user);
    }
    public Optional<User> getUserByLong(Long id) throws UserNotFoundException{
    	Optional<User> user=userRepository.findById(id);
    	if(!user.isPresent()) {
    		throw new UserNotFoundException("User not Found");
    	}
        return 	userRepository.findById(id);
    }
    
    
    public User updateUserById(Long id,User user) throws UserNotFoundException {
    	Optional<User> user1=userRepository.findById(id);
    	if(!user1.isPresent()) {
    		throw new UserNotFoundException("User not Found");
    	}
    	user.setId(id);
    	return userRepository.save(user);
    }
    
    public void delete(Long id) {
    	Optional<User> user2=userRepository.findById(id);
		if(user2.isPresent()) {
    		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"User not Found");
    	}	
		userRepository.deleteById(id);
		
	}
    
    public User getUserByUserName(String username) {
    	return userRepository.findByUsername(username);
    }
}
