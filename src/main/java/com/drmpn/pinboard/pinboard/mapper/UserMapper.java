package com.drmpn.pinboard.pinboard.mapper;

import org.mapstruct.Mapper;

import com.drmpn.pinboard.pinboard.dto.UserDTO;
import com.drmpn.pinboard.pinboard.model.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    
    UserDTO toDto(User user);

    User toUser(UserDTO gto);
    
}
