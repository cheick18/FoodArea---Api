package com.example.demo.mapper;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.CategoryResponseDto;
import com.example.demo.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    Category toEntity(CategoryDto categoryDto);
    @Mapping(source = "recipes", target = "recipes",defaultExpression = "java(new java.util.HashSet<>())")
    CategoryResponseDto toResponseDto(Category category);
    Set<CategoryResponseDto> toResponseDtoSet(Set<Category> categories);
}
