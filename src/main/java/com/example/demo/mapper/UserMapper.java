package com.example.demo.mapper;

import com.example.demo.dto.UserDTo;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.model.AppUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Set;
@Mapper
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
/*
    User toEntity(UserDTo userDto);
    /*
    @Mappings({
            @Mapping(source = "recipes",target = "recipes", defaultExpression = "java(new java.util.HashSet<>())"),
            @Mapping(target = "comments", defaultExpression = "java(new java.util.HashSet<>())")
    })

    UserResponseDto toResponseDto(User user);

    Set<UserResponseDto> toResponseDtoSet(Set<User> users);

 */
}
