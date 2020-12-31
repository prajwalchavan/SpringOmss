package com.project.omss.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.omss.entity.User;
import com.project.omss.exception.USERException;
import com.project.omss.repository.UserJpaRepository;
import com.project.omss.service.UserService;

@RestController
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@PostMapping("/Register")
	private String saveUser(@RequestBody User User) throws Exception {
		if (User.getUserId() != 0)
			return User.getUserId() + " " + userService.saveOrUpdate(User);
		else
			throw new USERException(" Exception Occured!!! USER field has incoreect data");
	}

	// user login
	@PostMapping("/login")
	public ResponseEntity<User> loginUser(@RequestParam("userId") int userId,
			@RequestParam("password") String password) {
		logger.info("User Login Method Started!");
		User user = userService.loginUser(userId, password);
		if (user != null) {
			return new ResponseEntity("Login Successfull!!!", HttpStatus.OK);
		}
		return new ResponseEntity("Login Failed!!!", HttpStatus.BAD_REQUEST);

	}

	@GetMapping("/getUsers")
	private List<User> getAllUsers() {
		logger.info("Users Retrived");
		return userService.getAllUsers();
	}

	@GetMapping("/profile/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") int userId, User user) {
		logger.info("User is fetched by user id!!!");
		if (user.getUserId() == userId) {
			return ResponseEntity.ok(userService.findOneById(userId));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
}
