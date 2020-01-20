package com.feastfreedom.feastfreedom.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.feastfreedom.feastfreedom.models.User;

public interface UserRepository extends MongoRepository<User, String> {
	
	public Optional<User> findById(String Userid);
	public User findByUserEmail(String UserEmail);
	public User findByUserPassword(String UserPassword);
}
