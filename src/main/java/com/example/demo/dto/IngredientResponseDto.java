package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter

public class IngredientResponseDto {
    private Long id;
    private String name;
    private int quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


    public IngredientResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public IngredientResponseDto(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public IngredientResponseDto(Long id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
}
