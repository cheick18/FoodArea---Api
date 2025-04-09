package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecipeDTO {
    @NotNull(message = "Recipe title can't be null")
    @Size(min = 2, max = 100, message = "Title should have between 2 and 100 characters")
    private String title;
    @NotNull(message = "Recipe instruction can't be null")
    @NotEmpty(message = "Recipe instructions can't be empty")
    private String instructions;
    @Positive(message = "Cooking time must be a positive value")
    private int cookingTime;
    private String imageUrl;
    private Set<Long> ingredientIds;
    private Long userId;
    private Long categoryId;
    private Set<Long> tagIds;
    private Set <Long> commentsIds;
}
