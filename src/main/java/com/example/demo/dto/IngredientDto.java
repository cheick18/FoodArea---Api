package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter

public class IngredientDto {
    @NotNull(message = "Ingredient name can't be null")
    @Size(min = 1, max = 100, message = "Ingredient name should be between 1 and 100 characters")
    private String name;
    @Positive(message = "Quantity must be a positive value")
    private int quantity;

    public IngredientDto(@NotNull(message = "Ingredient name can't be null") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public IngredientDto(@NotNull(message = "Ingredient name can't be null") String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

}
