package com.praksa.musicexplorer.support;

import java.util.List;

import org.mapstruct.Mapper;

import com.praksa.musicexplorer.model.Song;
import com.praksa.musicexplorer.web.dto.SongDTO;

@Mapper
public interface SongMapper {

	SongDTO toSongDTO(Song song);
	List<SongDTO> toSongDTOs(List<Song> song);
	Song toSong(SongDTO songDTO);
}
