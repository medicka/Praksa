package com.praksa.musicexplorer.service;

import java.util.List;

import com.praksa.musicexplorer.model.LikeSong;
import com.praksa.musicexplorer.model.LikeSongId;
import com.praksa.musicexplorer.model.Song;

public interface SongService {
	
	Song findOne(Long id);
	List<Song> findAll();
	Song save(Song song);
	void delete(Long id);
	List<Song> findByAlbumId(Long albumId);
	LikeSong like(LikeSongId likeId);
	Song findMostLiked();
	List<Song> search(String name, Long albumId);

}
