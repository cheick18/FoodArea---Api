package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    @NotNull(message = "Content can't be null")
    @Size(min = 5, max = 500, message = "Comment content should be between 5 and 500 characters")
    private String content;
    @Positive(message = "Rating must be a positive number")
    private int rating;
    private Long userId;
    private Long recipeId;
}
