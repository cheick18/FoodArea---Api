package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RecipeIngredientDto {
    @NotNull(message = "Ingredient can't be null")
    private Long id;
    @Positive(message = "Quantity must be a positive value")
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public RecipeIngredientDto(@NotNull(message = "Ingredient can't be null") Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
}
