package com.feastfreedom.feastfreedom.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feastfreedom.feastfreedom.mailService;
import com.feastfreedom.feastfreedom.models.User;
import com.feastfreedom.feastfreedom.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController extends User {

	@Autowired
	UserRepository Us;

	
	@PostMapping
	public User AddUser(@RequestBody User User) throws Exception{
		Us.save(User);
		mailService.userCreated(getUserEmail());
		return User;
	}

	@GetMapping
	public List<User> getAllUsers() {
		return Us.findAll();
	}
	
	@PutMapping("/{userId}")
	public User UpdateUser(@RequestBody User User, @PathVariable String UserId) {
		User.setId(UserId);
		Us.save(User);
		return User;
	}

	@DeleteMapping("/{userId}")
	public String DeleteUser(@PathVariable String UserId) {
		Us.deleteById(UserId);
		return "Deleted";
	}

}