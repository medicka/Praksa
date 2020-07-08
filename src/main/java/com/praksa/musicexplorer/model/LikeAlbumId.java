package com.praksa.musicexplorer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class LikeAlbumId implements Serializable{
	private static final long serialVersionUID = 1L;


	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "album_id")
	private Long albumId;

}
