package com.example.demo.dto;

import com.example.demo.model.AccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String login;
    private AccountType accountType;
    private Set<RecipeResponseDto> recipes;
    private Set<CommentResponseDto> comments;
}
