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

import com.praksa.musicexplorer.model.Artist;
import com.praksa.musicexplorer.service.ArtistService;
import com.praksa.musicexplorer.support.ArtistMapper;
import com.praksa.musicexplorer.web.dto.ArtistDTO;



@RestController
@RequestMapping(value="/api/artists")
public class ApiArtistController {
	
	@Autowired
	private ArtistService artistService;
	private ArtistMapper artistMapper;
	
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<ArtistDTO>> getArtists(){
		
		List<Artist> artists = artistService.findAll();
		if (artists == null || artists.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(artistMapper.toArtistDTOs(artists), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	ResponseEntity<ArtistDTO> getArtist(@PathVariable Long id){
		
		Artist artist = artistService.findOne(id);
		
		if(artist == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(artistMapper.toArtistDTO(artist), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<ArtistDTO> add(@Validated @RequestBody ArtistDTO newArtist){
		
		if (newArtist == null || newArtist.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Artist savedArtist = artistService.save(artistMapper.toArtist(newArtist));
		
		return new ResponseEntity<>(artistMapper.toArtistDTO(savedArtist), HttpStatus.CREATED);
	}
	
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Void> handle(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	
	@RequestMapping(method=RequestMethod.PUT, value="/{id}", consumes="application/json")
	public ResponseEntity<ArtistDTO> edit(@Validated @RequestBody ArtistDTO artistDTO, @PathVariable Long id){
		
		if(!id.equals(artistDTO.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Artist persisted = artistService.save(artistMapper.toArtist(artistDTO));
		
		return new ResponseEntity<>(artistMapper.toArtistDTO(persisted),HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	ResponseEntity<ArtistDTO> delete(@PathVariable Long id){
		
		Artist artist = artistService.findOne(id);
		
		if (artist == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		artistService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}