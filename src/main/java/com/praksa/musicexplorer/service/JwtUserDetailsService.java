package com.praksa.musicexplorer.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	/*
	 * @Autowired private PasswordEncoder bcryptEncoder;
	 * 
	 * @Autowired private UserDao userDao;
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/* User userNew = userDao.findByName(username); */

		if ("itengin".equals(username)) {
			return new org.springframework.security.core.userdetails.User("itengin",
					"$2a$10$W2/VM.tRMUpVHs3mK3vOYO/.sL5oqb44U2cbS4Pn8IuAoES0WHIOC", new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
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
