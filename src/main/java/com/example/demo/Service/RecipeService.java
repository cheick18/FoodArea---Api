package com.example.demo.Service;

import com.example.demo.dto.*;
import com.example.demo.mapper.RecipeMapper;
import com.example.demo.model.*;
import com.example.demo.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RecipeService {
  private final RecipeRepository recipeRepository;


  public RecipeService(RecipeRepository recipeRepository) {
    this.recipeRepository = recipeRepository;

  }
  public RecipeResponseDto createRecipe(RecipeDTO recipeDto){
    // Category category = ca.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    Recipe recipe = RecipeMapper.INSTANCE.toEntity(recipeDto);
    Recipe savedRecipe = recipeRepository.save(recipe);
    return RecipeMapper.INSTANCE.toResponseDto(savedRecipe);


  }
  public void deleteRecipe(){

  }
  public RecipeResponseDto UpdateRecipe(){
    return null;
  }
  public RecipeResponseDto getRecipeById(Long recipeId){
    return null;
  }
  public Set<RecipeResponseDto> getAllRecipes() {
    Set<RecipeResponseDto> recipeDtos = new HashSet<>();
    Iterable<Recipe> recipes = recipeRepository.findAll();
    recipes.forEach(recipe -> recipeDtos.add(RecipeMapper.INSTANCE.toResponseDto(recipe)));
    return recipeDtos;
  }
  /*

  @Override
  public Recipe toEntity(RecipeDTO recipeDto) {
    Recipe recipe=new Recipe();
    recipe.setTitle(recipe.getTitle());
    recipe.setCokingTime(recipeDto.getCookingTime());
    recipe.setInstructions(recipe.getInstructions());
    recipe.setImageUrl(recipe.getImageUrl());
    Set<Ingredient> ingredients = new HashSet<>();
    for (Long ingredientId : recipeDto.getIngredientIds()) {
      Ingredient ingredient = new Ingredient();
      ingredient.setId(ingredientId);
      ingredients.add(ingredient);
    }

    User user = new User();
    user.setId(recipeDto.getUserId());
    recipe.setUser(user);
    recipe.setIngredients(ingredients);

    Category category = new Category();
    category.setId(recipeDto.getCategoryId());
    recipe.setCategory(category);

    Set<Tag> tags = new HashSet<>();
    for (Long tagId : recipeDto.getTagIds()) {
      Tag tag = new Tag();
      tag.setId(tagId);
      tags.add(tag);
    }
    recipe.setTags(tags);
    return  recipe;
  }

  @Override
  public RecipeResponseDto toResponseDto(Recipe recipe) {
    if (recipe == null) {
      return null;
    }

    RecipeResponseDto responseDto = new RecipeResponseDto();
    responseDto.setId(recipe.getId());
    responseDto.setTitle(recipe.getTitle());
    responseDto.setInstructions(recipe.getInstructions());
    responseDto.setCookingTime(recipe.getCokingTime());
    responseDto.setImageUrl(recipe.getImageUrl());
    Set<IngredientResponseDto> ingredientDtos = new HashSet<>();
    for (Ingredient ingredient : recipe.getIngredients()) {
      IngredientResponseDto ingredientDto = new IngredientResponseDto();
      ingredientDto.setId(ingredient.getId());
      ingredientDtos.add(ingredientDto);
    }
    responseDto.setIngredients(ingredientDtos);

    UserResponseDto userDto = new UserResponseDto();
    userDto.setId(recipe.getUser().getId());
    responseDto.setUser(userDto);

    CategoryResponseDto categoryDto = new CategoryResponseDto();
    categoryDto.setId(recipe.getCategory().getId());
    responseDto.setCategory(categoryDto);

    Set<TagResponseDto> tagDtos = new HashSet<>();
    for (Tag tag : recipe.getTags()) {
      TagResponseDto tagDto = new TagResponseDto();
      tagDto.setId(tag.getId());
      tagDtos.add(tagDto);
    }
    responseDto.setTags(tagDtos);

    return null;
  }

  @Override
  public Set<RecipeResponseDto> toResponseDtoSet(Set<Recipe> recipes) {
    Set<RecipeResponseDto> responseDtos = new HashSet<>();
    for (Recipe recipe : recipes) {
      responseDtos.add(toResponseDto(recipe));
    }
    return responseDtos;
  }
  */
}