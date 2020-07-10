package com.praksa.musicexplorer.support;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import com.praksa.musicexplorer.model.User;
import com.praksa.musicexplorer.web.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserMapper INS_USER = Mappers.getMapper(UserMapper.class);
	UserDTO toUserDTO(User user);
	
	@Mappings({
		@Mapping(target="likesSongs", ignore=true),
		@Mapping(target="likesAlbums", ignore=true),
		@Mapping(target="likesArtists", ignore=true)
	})
	User toUser(UserDTO userDTO);
	

	/*
	 * default User fromId(final Long id) {
	 * 
	 * if (id == null) { return null; }
	 * 
	 * final User user=new User();
	 * 
	 * user.setId(id);
	 * 
	 * return user; }
	 */
}
