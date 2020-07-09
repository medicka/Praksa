package com.praksa.musicexplorer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;
@Data
@ToString(callSuper=true,exclude={"id", "likesSongs", "likesAlbums", "likesArtists"})
@Entity
@Table(name="tbl_user")
public class User {
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="username", nullable=false)
	private String username;
	
	@Column(name="password", nullable=false)
	private String password;
	
	
	/*
	 * @Column(name="surname", nullable=false)
	 * 
	 * @Getter @Setter private String surname;
	 */
	@OneToMany(mappedBy="user")
	private List<LikeSong> likesSongs = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<LikeAlbum> likesAlbums = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<LikeArtist> likesArtists = new ArrayList<>();
	
	public void addLikeSong(LikeSong likeS) {
		this.likesSongs.add(likeS);
	}
	
	public void addLikeAlbum(LikeAlbum likeA) {
		this.likesAlbums.add(likeA);
	}
	
	public void addLikeArtist(LikeArtist likeArt) {
		this.likesArtists.add(likeArt);
	}

	public User(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}
}
