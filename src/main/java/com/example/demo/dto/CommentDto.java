package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CommentDto {
    @NotNull(message = "Content can't be null")
    @Size(min = 5, max = 500, message = "Comment content should be between 5 and 500 characters")
    private String content;
    @Positive(message = "Rating must be a positive number")
    private int rating;
    private Long userId;
    private Long recipeId;

    public CommentDto(@NotNull(message = "Content can't be null") String content, int rating, Long userId, Long recipeId) {
        this.content = content;
        this.rating = rating;
        this.userId = userId;
        this.recipeId = recipeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }
}
