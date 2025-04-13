package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;


public class RecipeResponseDto {
    private Long id;
    private String title;
    private String instructions;
    private int cookingTime;
    private String imageUrl;
    private Set<IngredientResponseDto> ingredients;
    private List<CommentResponseDto> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RecipeResponseDto() {
    }

    public List<CommentResponseDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentResponseDto> comments) {
        this.comments = comments;
    }

    public Set<IngredientResponseDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientResponseDto> ingredients) {
        this.ingredients = ingredients;
    }

    public RecipeResponseDto(Long id, String title, String instructions, int cookingTime, String imageUrl, Set<IngredientResponseDto> ingredients) {
        this.id = id;
        this.title = title;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
    }

    public RecipeResponseDto(Long id, String title, String instructions, int cookingTime, String imageUrl, Set<IngredientResponseDto> ingredients, List<CommentResponseDto> comments) {
        this.id = id;
        this.title = title;
        this.instructions = instructions;
        this.cookingTime = cookingTime;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.comments = comments;
    }
}
