package com.praksa.musicexplorer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praksa.musicexplorer.model.LikeSong;
import com.praksa.musicexplorer.model.LikeSongId;
import com.praksa.musicexplorer.model.Song;
import com.praksa.musicexplorer.repository.LikeSongRepository;
import com.praksa.musicexplorer.repository.SongRepository;
import com.praksa.musicexplorer.service.SongService;



@Service
public class JpaSongService implements SongService {
	
	@Autowired
	private SongRepository songRepository;
	
	@Autowired
	private LikeSongRepository likeSongRepository;
	

	
	@Override
	public Song findOne(Long id) {
		return songRepository.findById(id).get();
	}

	@Override
	public List<Song> findAll() {
		return songRepository.findAll();
	}

	@Override
	public Song save(Song song) {
		return songRepository.save(song);
	}

	@Override
	public void delete(Long id) {
		songRepository.deleteById(id);
	}
		
	/*
	 * @Override public Page<Song> findAll(int page) { return
	 * pesmaRepository.findAll(new PageRequest(page, 14)); }
	 */
	/*
	 * @Override public Page<Pesma> pretraga(String naziv, Integer godinaIzdanja,
	 * Long albumId, Double minimalnaOcena, int page) { if(naziv != null) { naziv =
	 * '%' + naziv + '%'; }
	 * 
	 * 
	 * return pesmaRepository.pretraga(naziv, godinaIzdanja, albumId,
	 * minimalnaOcena, new PageRequest(page, 14)); }
	 */
	
	/*
	 * @Override public Ocena oceni (Pesma pesmaUBazi, Integer vrednost) {
	 * 
	 * List<Ocena> oceneUBazi = pesmaUBazi.getOcene();
	 * 
	 * double sum = 0; for(int i=0; i < oceneUBazi.size(); i++) { sum +=
	 * oceneUBazi.get(i).getVrednost(); }
	 * 
	 * double novaProsecnaOcena = (sum + vrednost)/(oceneUBazi.size()+1);
	 * 
	 * Ocena ocena = new Ocena(vrednost); ocenaRepository.save(ocena);
	 * 
	 * pesmaUBazi.addOcena(ocena); pesmaUBazi.setProsecnaOcena(novaProsecnaOcena);
	 * pesmaRepository.save(pesmaUBazi); ocena.setPesma(pesmaUBazi);
	 * ocenaRepository.save(ocena);
	 * 
	 * return ocena; }
	 */
	@Override
	public List<Song> findByAlbumId(Long albumId) {
		return songRepository.findByAlbumId(albumId);
	}
	
	@Override
	public Song findMostLiked() {
		
		  List<Song> songs = findAll(); 
		  Song max = songs.get(0);
		  int maxCount = songs.get(0).getLikeNumber();
		  for (Song s: songs) {
			  if(maxCount < s.getLikeNumber()) {
				  max = s;
				  maxCount = s.getLikeNumber();
			  }
		  }
		  
		  return max;
			/*
			 * max.setProsecnaOcena(0.0); max.setBrojOcena(0);
			 * 
			 * for(int i=0; i < songs.size(); i++) {
			 * 
			 * if (pesme.get(i).getProsecnaOcena() > max.getProsecnaOcena()) { max =
			 * pesme.get(i);
			 * 
			 * } pesme.get(i).getBrojOcena();
			 * 
			 * 
			 * if (pesme.get(i).getBrojOcena() > max.getBrojOcena() ) { if
			 * (pesme.get(i).getProsecnaOcena() >= max.getProsecnaOcena()) { max =
			 * pesme.get(i); System.out.println("Jel ulazi ovde?"); } }
			 * 
			 * }
			 * 
			 * System.out.println(max); return max;
			 */
	   
	}
	@Override
	public LikeSong like (LikeSongId likeId) { 
		
		LikeSong like = new LikeSong(likeId);
		likeSongRepository.save(like);
		
		/*
		 * songInDb.addLikes(like); songRepository.save(songInDb);
		 */
		
		return like;
	}

	@Override
	public List<Song> search(String name, Long albumId) {
		if(name != null) {
			name = '%' + name + '%';
		}
		
		return songRepository.search(name,albumId);
	}

	
}