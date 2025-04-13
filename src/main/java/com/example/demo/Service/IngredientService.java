package com.example.demo.Service;

import com.example.demo.dto.IngredientDto;
import com.example.demo.dto.IngredientResponseDto;
import com.example.demo.dto.RecipeResponseDto;
import com.example.demo.exception.IngredientNotFoundException;
import com.example.demo.mapper.IngredientMapper;
import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import com.example.demo.repository.IngredientRepository;
import org.hibernate.id.IncrementGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository)
    {
        this.ingredientRepository = ingredientRepository;
    }
    public IngredientResponseDto toResponseDto(Ingredient ingredient){
        return new IngredientResponseDto(ingredient.getId(),ingredient.getName());
    }
    public IngredientResponseDto createIngredient(IngredientDto ingredientDto){
        Ingredient ingredient= new Ingredient();
        Set<Recipe> recipes= new HashSet<>();
        ingredient.setRecipes(recipes);
        ingredient.setName(ingredientDto.getName());
        ingredient.setQuantity(0);

        return  toResponseDto(ingredientRepository.save(ingredient));

    }
    public IngredientResponseDto getIngredientById(Long id){
        Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IngredientNotFoundException(id));
        return toResponseDto(ingredient);
    }
    @Transactional
    public void deleteIngredient(Long id){
        Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IngredientNotFoundException(id));
        ingredientRepository.deleteById(id);
    }
    @Transactional
    public IngredientResponseDto updateIngredient(Long id, IngredientDto ingredientDto){Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IngredientNotFoundException(id));

      ingredient.setName(ingredientDto.getName());
      ingredient.setQuantity(ingredientDto.getQuantity());

      return toResponseDto(ingredientRepository.save(ingredient));

    }
    public Set<IngredientResponseDto> getAllIngredients(){
        List<Ingredient> ingredients= ingredientRepository.findAll();
        List<IngredientResponseDto> ingredientresponse=ingredients.stream().map(this::toResponseDto).toList();
        Set<IngredientResponseDto> ingredientsSet=new HashSet<>(ingredientresponse);
        return ingredientsSet;

    }



}
