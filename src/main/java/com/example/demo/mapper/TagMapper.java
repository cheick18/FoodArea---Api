package com.example.demo.mapper;

import com.example.demo.dto.TagDto;
import com.example.demo.dto.TagResponseDto;
import com.example.demo.model.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
@Mapper
public interface TagMapper {

    TagMapper INSTANCE= Mappers.getMapper(TagMapper.class);
/*
    Tag toEntity(TagDto tagDto);

    @Mapping(source="recipes", target = "recipes", defaultExpression = "java(new java.util.HashSet<>())")
    TagResponseDto toResponseDto(Tag tag);
    Set<TagResponseDto> toResponseDtoSet(Set<Tag> tags);

 */
}
