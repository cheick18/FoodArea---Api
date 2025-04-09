package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RecipeResponseDto {
    private Long id;
    private String title;
    private String instructions;
    private int cookingTime;
    private String imageUrl;
    private Set<IngredientResponseDto> ingredients;
    private UserResponseDto user;
    private CategoryResponseDto category;
    private Set<TagResponseDto> tags;
    private Set<CommentResponseDto> comments;
}
