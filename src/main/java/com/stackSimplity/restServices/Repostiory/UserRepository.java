package com.stackSimplity.restServices.Repostiory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackSimplity.restServices.entities.User;
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{ 
  User findByUsername(String username);
}
