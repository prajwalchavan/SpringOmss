package com.project.omss.service;

import java.util.List;

import com.project.omss.entity.User;

public interface UserService {

	String saveOrUpdate(User user);
	List<User> getAllUsers();

}
