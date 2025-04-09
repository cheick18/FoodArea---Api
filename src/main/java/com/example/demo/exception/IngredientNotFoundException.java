package com.example.demo.exception;

public class IngredientNotFoundException extends RuntimeException{
    public IngredientNotFoundException (Long id){
        super("Ingredient with"+id+"Not found");

    }
}
