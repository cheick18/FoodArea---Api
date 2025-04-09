package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientResponseDto {
    private Long id;
    private String name;
    private int quantity;
    private Set<RecipeResponseDto> recipes;
}
