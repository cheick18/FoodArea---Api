package com.example.demo.controller;

import com.example.demo.Service.CategoryService;
import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.CategoryResponseDto;
import com.example.demo.dto.RecipeResponseDto;
import com.example.demo.model.Category;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/api/categories")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDto categoryDto)
    {
        Category savedCategory=categoryService.createCategory(categoryDto);
        return ResponseEntity.ok(savedCategory);

    }
    @GetMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponseDto> getCategory(@PathVariable Long id)
    {
        CategoryResponseDto categoryResponse=categoryService.getCategoryById(id);
        return ResponseEntity.ok(categoryResponse);
    }

    @GetMapping("/api/categories")
    public ResponseEntity<Set<CategoryResponseDto>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }
    @GetMapping("/api/categories/{id}/recipes")
    public ResponseEntity<Set<RecipeResponseDto>> getAllRecipeByCategoryId(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getAllRecipeByCategory(id));

    }
    @DeleteMapping("/api/categories/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/api/categories/{id}")
    public ResponseEntity<CategoryResponseDto> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto){
      CategoryResponseDto categoryUpdates=categoryService.updateCategory(id,categoryDto);
        return ResponseEntity.ok(categoryUpdates);
    }



}
