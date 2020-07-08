package com.praksa.musicexplorer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praksa.musicexplorer.model.Artist;
import com.praksa.musicexplorer.model.LikeArtist;
import com.praksa.musicexplorer.model.LikeArtistId;
import com.praksa.musicexplorer.repository.ArtistRepository;
import com.praksa.musicexplorer.repository.LikeArtistRepository;
import com.praksa.musicexplorer.service.ArtistService;

@Service
public class JpaArtistService implements ArtistService {

	@Autowired
	private ArtistRepository artistRepository;
	
	@Autowired
	private LikeArtistRepository likeArtistRepository;
	
	
	@Override
	public List<Artist> findAll() {
		return artistRepository.findAll();
	}

	@Override
	public Artist findOne(Long id) {
		return artistRepository.findById(id).get();
	}

	@Override
	public Artist save(Artist artist) {
		return artistRepository.save(artist);
	}

	@Override
	public LikeArtist like(LikeArtistId likeId) {
		LikeArtist like = new LikeArtist(likeId);
		likeArtistRepository.save(like);
		
		/*
		 * likeId.addLikes(like); artistRepository.save(likeId);
		 */
		
		return like;
	}

	@Override
	public Artist findMostLiked() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		artistRepository.deleteById(id);
		
	}

}
