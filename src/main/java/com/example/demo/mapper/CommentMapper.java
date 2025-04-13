package com.example.demo.mapper;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.CommentResponseDto;
import com.example.demo.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Set;
@Mapper
public interface CommentMapper {
  CommentMapper  INSTANCE = Mappers.getMapper(CommentMapper.class);
  /*
    @Mappings({
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "recipeId", target = "recipe.id")
    })
    Comment toEntity(CommentDto commentDto);

    @Mappings({
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "recipe", target = "recipe")
    })
    CommentResponseDto toResponseDto(Comment comment);

    Set<CommentResponseDto> toResponseDtoSet(Set<Comment> comments);
    */

}
