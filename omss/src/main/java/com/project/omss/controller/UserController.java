package com.project.omss.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.omss.entity.User;
import com.project.omss.service.UserService;

@RestController
public class UserController {
	
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/UserAdd")
	private String saveUser(@RequestBody User User) {
		logger.info("New User Added");
	return User.getUserId() + " " + userService.saveOrUpdate(User);
	}
	
	@GetMapping("/getUsers")
	private List<User> getAllUsers() {
		logger.info("Users Retrived");
		return userService.getAllUsers();
	}
}
