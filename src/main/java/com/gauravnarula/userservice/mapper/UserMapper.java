package com.gauravnarula.userservice.mapper;

import com.gauravnarula.userservice.dto.AddUserDTO;
import com.gauravnarula.userservice.dto.UserDTO;
import com.gauravnarula.userservice.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);

    User toEntity(AddUserDTO dto);
}
