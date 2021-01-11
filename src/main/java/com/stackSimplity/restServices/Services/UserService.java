package com.stackSimplity.restServices.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackSimplity.restServices.Repostiory.UserRepository;
import com.stackSimplity.restServices.entities.User;



@Service
public class UserService {
    @Autowired
	private UserRepository userRepository;
    
    
    public List<User> getAllUser(){
    	return userRepository.findAll();
    }
    
    public User createuser(User user) {
    	return userRepository.save(user);
    }
    public Optional<User> getUserByLong(Long id){
        return 	userRepository.findById(id);
    }
    
    public User updateUserById(Long id,User user) {
    	user.setId(id);
    	return userRepository.save(user);
    }
    
    public void delete(Long id) {
		if(userRepository.findById(id).isPresent()) {
			userRepository.deleteById(id);
		}
	}
    
    public User getUserByUserName(String username) {
    	return userRepository.findByUsername(username);
    }
}
