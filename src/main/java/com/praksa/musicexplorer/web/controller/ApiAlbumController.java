package com.praksa.musicexplorer.web.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.praksa.musicexplorer.model.Album;
import com.praksa.musicexplorer.service.AlbumService;
import com.praksa.musicexplorer.support.AlbumMapper;
import com.praksa.musicexplorer.web.dto.AlbumDTO;


@RestController
@RequestMapping(value="/api/albums")
public class ApiAlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	private AlbumMapper albumMapper;
	
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<AlbumDTO>> getAlbums(){
		
		List<Album> albums = albumService.findAll();
		if (albums == null || albums.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(albumMapper.toAlbumDTOs(albums), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<AlbumDTO> getAlbum(@PathVariable Long id){
		
		Album album = albumService.findOne(id);
		
		if(album == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(albumMapper.toAlbumDTO(album), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<AlbumDTO> add(@Validated @RequestBody AlbumDTO newAlbum){
		
		if (newAlbum == null || newAlbum.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Album savedAlbum = albumService.save(albumMapper.toAlbum(newAlbum));
		
		return new ResponseEntity<>(albumMapper.toAlbumDTO(savedAlbum), HttpStatus.CREATED);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<AlbumDTO> edit(@Validated @RequestBody AlbumDTO albumDTO, @PathVariable Long id){
		
		if(!id.equals(albumDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Album persisted = albumService.save(albumMapper.toAlbum(albumDTO));
		
		return new ResponseEntity<>(albumMapper.toAlbumDTO(persisted),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<AlbumDTO> delete(@PathVariable Long id){
		
		Album album = albumService.findOne(id);
		
		if (album == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		albumService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}