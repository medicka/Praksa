package com.praksa.musicexplorer.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tbl_like_album")
public class LikeAlbum {
	
	@EmbeddedId
	@Getter @Setter private LikeAlbumId id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	@Getter @Setter private User user;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("album_id")
	@JoinColumn(name = "album_id")
	@Getter @Setter private Album album;

	public LikeAlbum(LikeAlbumId id) {
		super();
		this.id = id;
	}


}
