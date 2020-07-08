package com.praksa.musicexplorer.service;

import java.util.List;

import com.praksa.musicexplorer.model.LikeArtist;
import com.praksa.musicexplorer.model.LikeArtistId;

public interface LikeArtistService {
	
	List<LikeArtist> findAll();
	LikeArtist findOne(LikeArtistId id);
	LikeArtist save(LikeArtist like);
	void delete(LikeArtistId id);
	
}
