package com.praksa.musicexplorer.support;

import java.util.List;

import org.mapstruct.Mapper;

import com.praksa.musicexplorer.model.Album;
import com.praksa.musicexplorer.web.dto.AlbumDTO;


@Mapper
public interface AlbumMapper {

	AlbumDTO toAlbumDTO(Album album);
	List<AlbumDTO> toAlbumDTOs(List<Album> album);
	Album toAlbum(AlbumDTO albumDTO);
}
