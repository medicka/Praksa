package com.praksa.musicexplorer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true,exclude={"likes", "artist", "id"})
@Entity
@Table(name="tbl_album")
public class Album {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	@Getter @Setter private Long id;
	
	@Column(name="name")
	@Getter @Setter private String name;
	
	@Column(name="year")
	@Getter @Setter private Integer year;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@Getter @Setter private Artist artist;
	
	@Column(name="publisher")
	@Getter @Setter private String publisher;
	
	@Column(name="numberOfSongs")
	@Getter @Setter private Integer numberOfSongs;

	@JsonIgnore
	@OneToMany(mappedBy="album", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Getter @Setter private List<Song> songs = new ArrayList<>();
	
	@OneToMany(mappedBy="album", cascade = CascadeType.ALL)
	@Getter @Setter private List<LikeAlbum> likes = new ArrayList<>();

	public void addSong(Song song){
		this.songs.add(song);
		if(!this.equals(song.getAlbum())){
			song.setAlbum(this);
		}
	}
	
	public void addLikeAlbum(LikeAlbum likeAlbum){
		this.likes.add(likeAlbum);
	}
	
	public int getLikeNumber() {
		return getLikes().size();
	}

}
