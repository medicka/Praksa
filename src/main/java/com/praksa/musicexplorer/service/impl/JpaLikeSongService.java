package com.praksa.musicexplorer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praksa.musicexplorer.model.LikeSong;
import com.praksa.musicexplorer.model.LikeSongId;
import com.praksa.musicexplorer.repository.LikeSongRepository;
import com.praksa.musicexplorer.service.LikeSongService;

@Service
public class JpaLikeSongService implements LikeSongService {
	
	
	@Autowired
	private LikeSongRepository likeSongRepository;

	
	@Override
	public List<LikeSong> findAll() {
		
		return likeSongRepository.findAll();
	}
	
	@Override
	public LikeSong save(LikeSong like) {
		return likeSongRepository.save(like);
	}
	
	@Override
	public LikeSong findOne(LikeSongId id) {
		return likeSongRepository.findById(id).get();
	}
	
	@Override
	public void delete(LikeSongId id) {
		likeSongRepository.deleteById(id);
	}

}