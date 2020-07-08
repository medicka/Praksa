package com.praksa.musicexplorer.service;

import java.util.List;

import com.praksa.musicexplorer.model.LikeSong;
import com.praksa.musicexplorer.model.LikeSongId;

public interface LikeSongService {
	
	List<LikeSong> findAll();
	LikeSong findOne(LikeSongId id);
	LikeSong save(LikeSong like);
	void delete(LikeSongId id);

}
