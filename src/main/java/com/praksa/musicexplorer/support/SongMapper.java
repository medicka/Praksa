package com.praksa.musicexplorer.support;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.praksa.musicexplorer.model.Song;
import com.praksa.musicexplorer.web.dto.SongDTO;

@Mapper(componentModel = "spring")
public interface SongMapper {

	static SongMapper INS_SONG = Mappers.getMapper(SongMapper.class);

	@Mapping(source="album.id", target="albumId")
	SongDTO toSongDTO(Song song);

	// List<SongDTO> toSongDTOs(List<Song> song);
	@Mappings({ @Mapping(target = "album.id", source = "albumId"), @Mapping(target = "likes", ignore = true) })
	Song toSong(SongDTO songDTO);
}
