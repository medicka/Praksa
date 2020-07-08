package com.praksa.musicexplorer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praksa.musicexplorer.model.LikeAlbum;
import com.praksa.musicexplorer.model.LikeAlbumId;
import com.praksa.musicexplorer.repository.LikeAlbumRepository;
import com.praksa.musicexplorer.service.LikeAlbumService;

@Service
public class JpaLikeAlbumService implements LikeAlbumService {
	
	
	@Autowired
	private LikeAlbumRepository likeAlbumRepository;

	
	@Override
	public List<LikeAlbum> findAll() {
		
		return likeAlbumRepository.findAll();
	}
	
	@Override
	public LikeAlbum save(LikeAlbum like) {
		return likeAlbumRepository.save(like);
	}
	
	@Override
	public LikeAlbum findOne(LikeAlbumId id) {
		return likeAlbumRepository.findById(id).get();
	}
	
	@Override
	public void delete(LikeAlbumId id) {
		likeAlbumRepository.deleteById(id);
	}

}
