package com.praksa.musicexplorer.service;

import java.util.List;

import com.praksa.musicexplorer.model.Album;
import com.praksa.musicexplorer.model.LikeAlbum;
import com.praksa.musicexplorer.model.LikeAlbumId;


public interface AlbumService {
	
	List<Album> findAll();
	Album save(Album album);
	Album findOne(Long id);
	List<Album> findByArtistId(Long id);
	Album findMostLiked();
	LikeAlbum like(LikeAlbumId likeId);
	void delete(Long id);

}
