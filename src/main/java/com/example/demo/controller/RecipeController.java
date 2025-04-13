package com.example.demo.controller;

import com.example.demo.Service.RecipeService;
import com.example.demo.dto.IngredientDto;
import com.example.demo.dto.RecipeDTO;
import com.example.demo.dto.RecipeResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    @PostMapping("/api/recipes")

    public ResponseEntity<RecipeResponseDto> createRecipe(@Valid @RequestBody RecipeDTO recipeDto){
        return ResponseEntity.ok(recipeService.createRecipe(recipeDto));
    }
    @GetMapping("/api/recipes/{id}")
    public ResponseEntity<RecipeResponseDto> getRecipe(@PathVariable Long id){
        return ResponseEntity.ok(recipeService.getRecipe(id));

    }
    @GetMapping("/api/recipes")
    public ResponseEntity<Set<RecipeResponseDto>> getAllRecipes(){
        return ResponseEntity.ok(recipeService.getAllRecipes());

    }
    @GetMapping("/api/ingrdeints/recipes")
    public ResponseEntity<Set<RecipeResponseDto>> getAllRecipesByIngrdients(@RequestParam Set<Long> ingredientIds){
        return ResponseEntity.ok(recipeService.getAllRecipes());

    }
    @PutMapping("/api/recipes/{id}")
    public  ResponseEntity<RecipeResponseDto> upddateRecipe(@PathVariable Long id,@Valid @RequestBody RecipeDTO recipeDto){
        return  ResponseEntity.ok(recipeService.updateRecipe(id,recipeDto));

    }
    @DeleteMapping("/api/recipes/{id}")
    public ResponseEntity<Void> deleteRecipe(@PathVariable Long id){
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
