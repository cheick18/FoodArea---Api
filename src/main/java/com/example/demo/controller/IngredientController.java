package com.example.demo.controller;

import com.example.demo.Service.IngredientService;
import com.example.demo.dto.IngredientDto;
import com.example.demo.dto.IngredientResponseDto;
import com.example.demo.mapper.IngredientMapper;
import com.example.demo.model.Ingredient;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IngredientController {
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @PostMapping("/api/ingredients")
    public ResponseEntity<IngredientResponseDto> createIngredient(@Valid @RequestBody IngredientDto ingredientDto){

      IngredientResponseDto savedIngredient=ingredientService.createIngredient(ingredientDto);
        return ResponseEntity.ok(savedIngredient);
    }
    @GetMapping("/api/ingredients/{id}")
    public ResponseEntity<IngredientResponseDto> getIngredient(@PathVariable Long id){
        IngredientResponseDto ingredient=ingredientService.getIngredientById(id);
        return ResponseEntity.ok(ingredient);
    }
    @DeleteMapping("/api/ingredients/{id}")
    public ResponseEntity<Void> deleteIngredient(@PathVariable Long id){
        ingredientService.deleteIngredient(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/api/ingredients/{id}")
    public ResponseEntity<IngredientResponseDto> updateIngredient(@PathVariable Long id,@Valid @RequestBody IngredientDto ingredientDto){
        IngredientResponseDto ingredientUpdates= ingredientService.updateIngredient(id,ingredientDto);
        return ResponseEntity.ok(ingredientUpdates);
    }
}
