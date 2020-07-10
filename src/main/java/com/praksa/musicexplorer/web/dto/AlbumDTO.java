package com.praksa.musicexplorer.web.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class AlbumDTO {

	private Long id;

	@NotEmpty
	@NotBlank
	private String name;
	
	
	private Integer year;
	
	
	private Long artistId;
	
	
	private String publisher;
	
	
	private Integer numberOfSongs;
	
}
