package com.praksa.musicexplorer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praksa.musicexplorer.model.Album;
import com.praksa.musicexplorer.model.LikeAlbum;
import com.praksa.musicexplorer.model.LikeAlbumId;
import com.praksa.musicexplorer.repository.AlbumRepository;
import com.praksa.musicexplorer.repository.LikeAlbumRepository;
import com.praksa.musicexplorer.service.AlbumService;


@Service
public class JpaAlbumService implements AlbumService {
	
	@Autowired
	private AlbumRepository albumRepository;
	
	@Autowired
	private LikeAlbumRepository likeAlbumRepository;

	@Override
	public List<Album> findAll() {
		
		return albumRepository.findAll();
	}
	
	@Override
	public Album save(Album album) {
		return albumRepository.save(album);
	}
	
	@Override
	public Album findOne(Long id) {
		return albumRepository.findById(id).get();
	}
	
	/*
	 * @Override public Album findMostLiked() { List<Album> albums = findAll();
	 * Album max = albums.get(0);
	 * 
	 * 
	 * for(int i=0; i < albums.size(); i++) { if(albums.get(i).getBrojGlasova() >
	 * max.getBrojGlasova()){ max = albumi.get(i); } }
	 * 
	 * 
	 * return max; }
	 */
	
	@Override
	public LikeAlbum like (LikeAlbumId likeId ) { 
		
		//proveri da li da vraca LikeAlbum ili da bude void
		
		LikeAlbum like = new LikeAlbum(likeId);
		likeAlbumRepository.save(like);
		
		/*
		 * albumInDb.addLikeAlbum(like); albumRepository.save(albumInDb);
		 */
		return like;
	}

	@Override
	public List<Album> findByArtistId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Album findMostLiked() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		albumRepository.deleteById(id);
		
	}
	
}

