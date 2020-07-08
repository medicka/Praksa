package com.praksa.musicexplorer.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(callSuper=true,exclude={"id", "likes"})
@Entity
@Table(name="tbl_artist")
public class Artist {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	@Getter @Setter private Long id;
	
	@Column(name="name", nullable=false)
	@Getter @Setter private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="artist", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Getter @Setter private List<Album> albums = new ArrayList<>();
	
	@OneToMany(mappedBy="artist")
	@Getter @Setter private List<LikeArtist> likes = new ArrayList<>();

	
	public int getLikeNumber() {
		return getLikes().size();
	}
	
	public void addLikes(LikeArtist likeArtist ){
		this.likes.add(likeArtist);
	}
	
}
