package com.example.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


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
    @NotNull(message = "Ingredient  can't be null")
    private List<RecipeIngredientDto> ingredients;
    private Long userId;
    @NotNull(message = "Category  can't be null")
    private Long categoryId;
    private Set<Long> tagIds;

    public Set<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(Set<Long> tagIds) {
        this.tagIds = tagIds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }



    public RecipeDTO() {
    }

    public List<RecipeIngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeDTO(@NotNull(message = "Recipe title can't be null") String title, @NotNull(message = "Recipe instruction can't be null") String instructions, int cookingTime, String imageUrl, @NotNull(message = "Ingredient  can't be null") List<RecipeIngredientDto> ingredients, Long userId, @NotNull(message = "Category  can't be null") Long categoryId) {
        this.title = title;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public RecipeDTO(@NotNull(message = "Recipe title can't be null") String title, @NotNull(message = "Recipe instruction can't be null") String instructions, int cookingTime, String imageUrl, @NotNull(message = "Ingredient  can't be null") List<RecipeIngredientDto> ingredients, Long userId, @NotNull(message = "Category  can't be null") Long categoryId, Set<Long> tagIds) {
        this.title = title;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.userId = userId;
        this.categoryId = categoryId;
        this.tagIds = tagIds;
    }
}
