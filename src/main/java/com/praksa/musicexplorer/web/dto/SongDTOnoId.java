package com.praksa.musicexplorer.web.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class SongDTOnoId {

	@NotEmpty
	@NotBlank
	private String name;
	
	private Double duration;
	
	private Long albumId;
}
