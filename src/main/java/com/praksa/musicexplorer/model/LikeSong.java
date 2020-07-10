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
@Table(name="tbl_like_song")
@NoArgsConstructor
public class LikeSong {

	@EmbeddedId
	@Getter @Setter private LikeSongId id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("user_id")
	@JoinColumn(name = "user_id")
	@Getter @Setter private User user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@MapsId("song_id")
	@JoinColumn(name = "song_id")
	@Getter @Setter private Song song;

	public LikeSong(LikeSongId id) {
		super();
		this.id = id;
	}
	
	

}