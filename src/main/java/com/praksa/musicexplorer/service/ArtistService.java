package com.praksa.musicexplorer.service;

import java.util.List;

import com.praksa.musicexplorer.model.Artist;
import com.praksa.musicexplorer.model.LikeArtist;
import com.praksa.musicexplorer.model.LikeArtistId;

public interface ArtistService {

	List<Artist> findAll();
	Artist findOne(Long id);
	Artist save(Artist artist);
	LikeArtist like(LikeArtistId likeId);
	Artist findMostLiked();
	void delete(Long id);
}
