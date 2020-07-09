package com.praksa.musicexplorer.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.praksa.musicexplorer.config.JwtTokenUtil;
import com.praksa.musicexplorer.model.JwtRequest;
import com.praksa.musicexplorer.model.JwtResponse;
import com.praksa.musicexplorer.model.User;
import com.praksa.musicexplorer.service.JwtUserDetailsService;
import com.praksa.musicexplorer.service.UserService;
import com.praksa.musicexplorer.web.dto.UserDTO;

@RestController
//@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		System.out.println("Enter Authentication1");

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new JwtResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			System.out.println("Enter Authentication2");
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> saveUser(@Validated @RequestBody UserDTO newUser) throws Exception {
		System.out.println("Enter register");
	
		User user = new User();
		user.setUsername(newUser.getUsername());
		user.setPassword(encoder.encode(newUser.getPassword()));
		
		return ResponseEntity.ok(this.userService.save(user));
	}
	
	/*
	 * @DeleteMapping(value = "/delete{id}") ResponseEntity<?> delete(@PathVariable
	 * Long id)throws Exception{
	 * 
	 * User user = userService.findOne(id);
	 * 
	 * if (user == null) { return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
	 * 
	 * userService.delete(id);
	 * 
	 * return new ResponseEntity<>(HttpStatus.NO_CONTENT); }
	 */

	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> delete(@Validated @RequestBody  UserDTO userDTO) throws Exception{
		System.out.println("Enter delete");
		Long userId = userDTO.getId();
		
		if (userId == null) { 
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
			}
		userService.delete(userId);
		System.out.println("Delete");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
