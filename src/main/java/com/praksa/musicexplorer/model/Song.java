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
@ToString(callSuper=true,exclude={"id", "album", "likes"})
@Entity
@Table(name="tbl_song")
public class Song {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	@Getter @Setter private Long id;
	
	@Column(name="name", nullable=false)
	@Getter @Setter private String name;
	
	@Column(name="duration")
	@Getter @Setter private Double duration;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@Getter @Setter private Album album;
	
	@OneToMany(mappedBy="song", cascade = CascadeType.ALL)
	@Getter @Setter private List<LikeSong> likes = new ArrayList<>();

	
	public void addLikes(LikeSong likeSong ){
		this.likes.add(likeSong);
	}
	
	public int getLikeNumber() {
		return getLikes().size();
	}

}
