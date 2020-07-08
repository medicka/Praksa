package com.praksa.musicexplorer.service;

import java.util.List;

import com.praksa.musicexplorer.model.User;

public interface UserService {

	List<User> findAll();
	User findOne(Long id);
	User save(User user);
	void delete(Long id);
	
}
