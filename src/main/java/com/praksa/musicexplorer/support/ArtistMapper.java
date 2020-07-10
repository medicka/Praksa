package com.praksa.musicexplorer.support;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.praksa.musicexplorer.model.Artist;
import com.praksa.musicexplorer.web.dto.ArtistDTO;

@Mapper(componentModel = "spring")
public interface ArtistMapper {

	ArtistMapper INS_ARTIST = Mappers.getMapper(ArtistMapper.class);
	
	ArtistDTO toArtistDTO(Artist artist);
	//List<ArtistDTO>  toArtistDTOs(List<Artist> artists);
	@Mappings({
		@Mapping(target="albums", ignore=true),
		@Mapping(target="likes", ignore=true)
	})
	Artist toArtist(ArtistDTO artistDTO);
}
