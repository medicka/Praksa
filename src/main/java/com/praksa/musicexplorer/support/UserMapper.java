package com.praksa.musicexplorer.support;

import org.mapstruct.Mapper;

import com.praksa.musicexplorer.model.User;
import com.praksa.musicexplorer.web.dto.UserDTO;

@Mapper
public interface UserMapper {

	UserDTO toUserDTO(User user);
	User toUser(UserDTO userDTO);
}
