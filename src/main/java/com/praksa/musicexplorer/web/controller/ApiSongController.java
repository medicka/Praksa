package com.praksa.musicexplorer.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.praksa.musicexplorer.model.Song;
import com.praksa.musicexplorer.service.SongService;
import com.praksa.musicexplorer.support.SongMapper;
import com.praksa.musicexplorer.support.SongMapperNoId;
import com.praksa.musicexplorer.web.dto.SongDTO;
import com.praksa.musicexplorer.web.dto.SongDTOnoId;



@RestController
@RequestMapping(value="/api/songs")
public class ApiSongController {
	
	@Autowired
	private SongService songService;

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SongDTO>> getSongs(
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Long albumId) throws Exception{
		
		List<Song> songs = null;
		
		if(name != null || albumId != null ) {
			songs = songService.search(name, albumId);
		} else {
			songs = songService.findAll();
			
		}		
		
		if (songs == null || songs.isEmpty()) {
			System.out.println("songs is null");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<SongDTO> songsDTO = new ArrayList<SongDTO>();
		for(Song s:songs) {
			songsDTO.add(SongMapper.INS_SONG.toSongDTO(s));
		}

		System.out.println("songs is not null");
		return new ResponseEntity<>(songsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<SongDTO> getSong(@PathVariable Long id){
		
		Song song = songService.findOne(id);
		
		if(song == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(SongMapper.INS_SONG.toSongDTO(song), HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<SongDTO> delete(@PathVariable Long id){
		
		Song song = songService.findOne(id);
		
		if (song == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		songService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<SongDTOnoId> add(@Validated @RequestBody SongDTOnoId newSong){
		
		if (newSong == null || newSong.getAlbumId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Song savedSong = songService.save(SongMapperNoId.INS_SONG.toSong(newSong));
		
		return new ResponseEntity<>(SongMapperNoId.INS_SONG.toSongDTOnoId(savedSong), HttpStatus.CREATED);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<SongDTO> edit(@Validated @RequestBody SongDTO songDTO, @PathVariable Long id){
		
		if(!id.equals(songDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Song persisted = songService.save(SongMapper.INS_SONG.toSong(songDTO));
		
		return new ResponseEntity<>(SongMapper.INS_SONG.toSongDTO(persisted),HttpStatus.OK);
	}
}
