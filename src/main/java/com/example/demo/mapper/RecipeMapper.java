package com.example.demo.mapper;

import com.example.demo.dto.RecipeDTO;
import com.example.demo.dto.RecipeResponseDto;
import com.example.demo.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper
public interface RecipeMapper {

    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);
    /*
    @Mappings({
            @Mapping(source = "ingredientIds", target = "ingredients"),
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "categoryId", target = "category.id"),
            @Mapping(source = "tagIds", target = "tags", defaultValue = "emptySet()"),
            @Mapping(source="commentIds",target = "comments", defaultValue = "emptySet()")
    })
    Recipe toEntity(RecipeDTO recipeDto);

    @Mappings({
            @Mapping(source = "ingredients", target = "ingredients"),
            @Mapping(source = "user", target = "user"),
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "tags", target = "tags"),
            @Mapping( source = "comments",target = "comments")
    })
    RecipeResponseDto toResponseDto(Recipe recipe);
    Set<RecipeResponseDto> toResponseDtoSet(Set<Recipe> recipes);
    */
}
