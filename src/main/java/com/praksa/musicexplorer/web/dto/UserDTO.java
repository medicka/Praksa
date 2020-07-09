package com.praksa.musicexplorer.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserDTO {

	private Long id;
	
	@NotEmpty
	@NotBlank
	private String username;
	
	@NotEmpty
	@NotBlank
	private String password;
	
	
	/*
	 * @NotEmpty
	 * 
	 * @NotBlank private String surname;
	 */
}
