package com.praksa.musicexplorer.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.praksa.musicexplorer.model.User;
import com.praksa.musicexplorer.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDao.findByUsername(username); 
		int count =0;
		System.out.println("Enter loader " + count);
		count++;

		if (user == null) {
			System.out.println("user null");
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		System.out.println("In loader user not null");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());

		/*
		 * if ("itengin".equals(username)) { System.out.println("Enter username ok");
		 * return new org.springframework.security.core.userdetails.User(username,
		 * encoder.encode("password"), new ArrayList<>()); } else { throw new
		 * UsernameNotFoundException("User not found with username: " + username); }
		 */
	}

	/*
	 * public User save(UserDTO user) { User newUser = new User();
	 * newUser.setUsername(user.getUsername());
	 * newUser.setPassword(bcryptEncoder.encode(user.getPassword())); return
	 * user.save(newUser);
	 * 
	 * }
	 */
}
