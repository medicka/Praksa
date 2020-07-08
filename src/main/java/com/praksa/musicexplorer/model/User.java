package com.praksa.musicexplorer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true,exclude={"id", "likesSongs", "likesAlbums", "likesArtists"})
@Entity
@Table(name="tbl_user")
public class User {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	@Getter @Setter private Long id;
	
	@Column(name="name", nullable=false)
	@Getter @Setter private String name;
	
	@Column(name="surname", nullable=false)
	@Getter @Setter private String surname;
	
	@OneToMany(mappedBy="user")
	@Getter @Setter private List<LikeSong> likesSongs = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	@Getter @Setter private List<LikeAlbum> likesAlbums = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	@Getter @Setter private List<LikeArtist> likesArtists = new ArrayList<>();
	
	public void addLikeSong(LikeSong likeS) {
		this.likesSongs.add(likeS);
	}
	
	public void addLikeAlbum(LikeAlbum likeA) {
		this.likesAlbums.add(likeA);
	}
	
	public void addLikeArtist(LikeArtist likeArt) {
		this.likesArtists.add(likeArt);
	}
}
