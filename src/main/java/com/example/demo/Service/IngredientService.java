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

import java.util.Set;

@Service
public class IngredientService {

    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository)
    {
        this.ingredientRepository = ingredientRepository;
    }
    public IngredientResponseDto createIngredient(IngredientDto ingredientDto){
        Ingredient ingredient=  IngredientMapper.INSTANCE.toEntity(ingredientDto);

        return IngredientMapper.INSTANCE.toResponseDto(ingredientRepository.save(ingredient));

    }
    public IngredientResponseDto getIngredientById(Long id){
        Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IngredientNotFoundException(id));
        return IngredientMapper.INSTANCE.toResponseDto(ingredient);
    }
    @Transactional
    public void deleteIngredient(Long id){
        Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IngredientNotFoundException(id));
        ingredientRepository.deleteById(id);
    }
    @Transactional
    public IngredientResponseDto updateIngredient(Long id, IngredientDto ingredientDto){Ingredient ingredient=ingredientRepository.findById(id).orElseThrow(()->new IngredientNotFoundException(id));
      Ingredient ingredientUpdated=IngredientMapper.INSTANCE.toEntity(ingredientDto);
      ingredient.setName(ingredientUpdated.getName());
      ingredient.setQuantity(ingredientUpdated.getQuantity());
      ingredient.setRecipes(ingredientUpdated.getRecipes());
      return IngredientMapper.INSTANCE.toResponseDto(ingredientRepository.save(ingredient));

    }
    public Set<IngredientResponseDto> getAllIngredients(){
        Set<Ingredient> ingredients= (Set<Ingredient>) ingredientRepository.findAll();
        return IngredientMapper.INSTANCE.toResponseDtoSet(ingredients);

    }



}
