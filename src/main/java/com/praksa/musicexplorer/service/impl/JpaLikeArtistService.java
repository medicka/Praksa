package com.praksa.musicexplorer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praksa.musicexplorer.model.LikeArtist;
import com.praksa.musicexplorer.model.LikeArtistId;
import com.praksa.musicexplorer.repository.LikeArtistRepository;
import com.praksa.musicexplorer.service.LikeArtistService;

@Service
public class JpaLikeArtistService implements LikeArtistService {
	
	
	@Autowired
	private LikeArtistRepository likeArtistRepository;

	
	@Override
	public List<LikeArtist> findAll() {
		
		return likeArtistRepository.findAll();
	}
	
	@Override
	public LikeArtist save(LikeArtist like) {
		return likeArtistRepository.save(like);
	}
	
	@Override
	public LikeArtist findOne(LikeArtistId id) {
		return likeArtistRepository.findById(id).get();
	}
	
	@Override
	public void delete(LikeArtistId id) {
		likeArtistRepository.deleteById(id);
	}

}