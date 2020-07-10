package com.praksa.musicexplorer.support;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.praksa.musicexplorer.model.Song;
import com.praksa.musicexplorer.web.dto.SongDTOnoId;

@Mapper(componentModel = "spring")
public interface SongMapperNoId {

	SongMapperNoId INS_SONG = Mappers.getMapper(SongMapperNoId.class);

	@Mapping(source="album.id", target="albumId")
	SongDTOnoId toSongDTOnoId(Song song);

	// List<SongDTO> toSongDTOs(List<Song> song);
	@Mappings({ @Mapping(target = "album.id", source = "albumId"), @Mapping(target = "likes", ignore = true) })
	Song toSong(SongDTOnoId songDTOnoId);

}
