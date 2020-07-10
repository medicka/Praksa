package com.praksa.musicexplorer.model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tbl_like_artist")
@NoArgsConstructor
public class LikeArtist {

	@EmbeddedId
	@Getter @Setter private LikeArtistId id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	@Getter @Setter private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("artist_id")
	@JoinColumn(name = "artist_id")
	@Getter @Setter private Artist artist;

	public LikeArtist(LikeArtistId id) {
		super();
		this.id = id;
	}
	
	
}
