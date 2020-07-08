package com.praksa.musicexplorer.service;

import java.util.List;

import com.praksa.musicexplorer.model.LikeAlbum;
import com.praksa.musicexplorer.model.LikeAlbumId;

public interface LikeAlbumService {

	LikeAlbum save(LikeAlbum like);
	List<LikeAlbum> findAll();
	LikeAlbum findOne(LikeAlbumId id);
	void delete(LikeAlbumId id);
	
}
