package com.example.demo.converter;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

 @Mapper(componentModel = "spring")
public interface UserConverter {
     @Mapping(target="roleName", source = "role.name")
    UserDTO toDTO(User entity);
}
