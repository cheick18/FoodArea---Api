package com.example.demo.mapper;

import com.example.demo.dto.IngredientDto;
import com.example.demo.dto.IngredientResponseDto;
import com.example.demo.dto.RecipeResponseDto;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Set;
@Mapper
public interface IngredientMapper {

    IngredientMapper INSTANCE = Mappers.getMapper(IngredientMapper.class);
    /*
    @Mapping(source="recipeIds", target = "recipes", defaultExpression = "java(new java.util.HashSet<>())")
    Ingredient toEntity(IngredientDto ingredientDto);

    @Mapping(source="recipes", target = "recipes", defaultExpression = "java(new java.util.HashSet<>())")
    IngredientResponseDto toResponseDto(Ingredient ingredient);
    Set<IngredientResponseDto> toResponseDtoSet(Set<Ingredient> ingredients);

     */
}
