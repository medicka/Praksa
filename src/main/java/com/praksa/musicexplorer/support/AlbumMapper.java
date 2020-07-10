package com.praksa.musicexplorer.support;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.praksa.musicexplorer.model.Album;
import com.praksa.musicexplorer.web.dto.AlbumDTO;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

	AlbumMapper INS_ALBUM = Mappers.getMapper(AlbumMapper.class);

	@Mapping(source = "artist.id", target = "artistId")
	AlbumDTO toAlbumDTO(Album album);

	// List<AlbumDTO> toAlbumDTOs(List<Album> album);
	@Mappings({ 
		@Mapping(target = "artist.id", source = "artistId"), 
		@Mapping(target = "songs", ignore = true),
		@Mapping(target = "likes", ignore = true) })
	Album toAlbum(AlbumDTO albumDTO);
}
