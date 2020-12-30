package com.project.omss.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.omss.entity.User;
import com.project.omss.repository.UserJpaRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
 	UserJpaRepository userRepository;

	@Override
	public String saveOrUpdate(User user) {
		userRepository.save(user);
		return "User Registered";
	}

	@Override
	public List<User> getAllUsers() {
		List<User> user = new ArrayList<User>();
       	userRepository.findAll().forEach(u1 -> user.add(u1));
       	return user;
	}
}
