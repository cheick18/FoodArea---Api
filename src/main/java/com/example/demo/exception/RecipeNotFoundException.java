package com.example.demo.exception;

public class RecipeNotFoundException extends RuntimeException{
    public RecipeNotFoundException (Long id){
        super("Recipe with "+id+"not found");
    }
}
