package com.praksa.musicexplorer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praksa.musicexplorer.model.User;
import com.praksa.musicexplorer.repository.UserRepository;
import com.praksa.musicexplorer.service.UserService;

@Service
public class JpaUserService implements UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User findOne(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
		
	}

}
