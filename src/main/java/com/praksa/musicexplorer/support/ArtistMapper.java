package com.praksa.musicexplorer.support;

import java.util.List;

import org.mapstruct.Mapper;

import com.praksa.musicexplorer.model.Artist;
import com.praksa.musicexplorer.web.dto.ArtistDTO;

@Mapper
public interface ArtistMapper {

	ArtistDTO toArtistDTO(Artist artist);
	List<ArtistDTO>  toArtistDTOs(List<Artist> artists);
	Artist toArtist(ArtistDTO artistDTO);
}
