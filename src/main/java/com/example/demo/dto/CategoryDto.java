package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;



public class CategoryDto {
    @NotNull(message = "Category name can't be null")
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CategoryDto() {
    }

    public CategoryDto(@NotNull(message = "Category name can't be null") String name, String description) {
        this.name = name;
        this.description = description;
    }
}
