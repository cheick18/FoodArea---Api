package com.example.demo.Service;
import com.example.demo.dto.*;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.exception.RecipeNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService {
  private final RecipeRepository recipeRepository;
  private final CategoryRepository categoryRepository;
  private final UserRepository userRepository;
  private final IngredientRepository ingredientRepository;
  private final TagRepository tagRepository;

    public RecipeService(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UserRepository userRepository, IngredientRepository ingredientRepository, TagRepository tagRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.ingredientRepository = ingredientRepository;
        this.tagRepository = tagRepository;
    }

public RecipeResponseDto toResponseDto(Recipe recipe){

        Set<IngredientResponseDto> ingredientResponse=new HashSet<>();
        recipe.getIngredients().forEach(ingredient -> {
            IngredientResponseDto ingredientResponseDto=new IngredientResponseDto(ingredient.getId(),ingredient.getName(),ingredient.getQuantity());
            ingredientResponse.add(ingredientResponseDto);
        });
        RecipeResponseDto recipedto=new RecipeResponseDto();
    if(recipe.getComments().size()>0){
        Set<Comment> listcomments=recipe.getComments();
        List<CommentResponseDto> commentResponseDtos=new ArrayList<>();
        listcomments.forEach(comment -> {
            commentResponseDtos.add(new CommentResponseDto(comment.getId(), comment.getContent(),comment.getRating(), comment.getUser().getLogin()));

        });
        recipedto.setComments(commentResponseDtos);
    }

        recipedto.setId(recipe.getId());
        recipedto.setTitle(recipe.getTitle());
        recipedto.setId(recipedto.getId());
        recipedto.setCookingTime(recipe.getCokingTime());
        recipedto.setInstructions(recipe.getInstructions());
        recipedto.setImageUrl(recipe.getImageUrl());
        recipedto.setInstructions(recipe.getInstructions());
        recipedto.setIngredients(ingredientResponse);

        return recipedto;

}
@Transactional
    public RecipeResponseDto createRecipe(RecipeDTO recipeDto) {
        Recipe recipe = new Recipe();
        Set<Comment> comments=new HashSet<>();
        Set<Tag> mytags=new HashSet<>();
        Category category = categoryRepository.findById(recipeDto.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException(recipeDto.getCategoryId()));
        AppUser user = userRepository.findById(recipeDto.getUserId()).orElseThrow(() -> new UserNotFoundException(recipeDto.getUserId()));

        Set<Long> ingrdientIds = new HashSet<>();
        recipeDto.getIngredients().forEach(recipeIngredientDto -> {
            ingrdientIds.add(recipeIngredientDto.getId());
        });
        List<Ingredient> ingredientList = ingredientRepository.findAllById(ingrdientIds);
        if (ingrdientIds.size() != recipeDto.getIngredients().size()) {
            throw new RuntimeException("Ingrdient not found");
        }
        Map<Long, Integer> idToQuantityMap = recipeDto.getIngredients()
                .stream()
                .collect(Collectors.toMap(RecipeIngredientDto::getId, RecipeIngredientDto::getQuantity));
        for (Ingredient ingredient : ingredientList) {
            Integer newQuantity = idToQuantityMap.get(ingredient.getId());
            ingredient.setQuantity(newQuantity);
        }
        Set<Ingredient> ingredients = new HashSet<>(ingredientList);
        recipe.setUser(user);

        recipe.setCategory(category);
        recipe.setTitle(recipeDto.getTitle());
        recipe.setInstructions(recipeDto.getInstructions());
        recipe.setImageUrl(recipeDto.getImageUrl());
        recipe.setCokingTime(recipeDto.getCookingTime());
        recipe.setIngredients(ingredients);
        recipe.setComments(comments);
        recipe.setTags(mytags);

        Recipe saved=recipeRepository.save(recipe);
      Set<Recipe> newRecipes=  category.getRecipes();
      newRecipes.add(saved);
      category.setRecipes(newRecipes);
        categoryRepository.save(category);
        if(recipeDto.getTagIds()!=null&&recipeDto.getTagIds().size()>0)
        {
            List<Tag> tags=tagRepository.findAllById(recipeDto.getTagIds());
            if(tags.size()>0) {
                Set<Tag> tagSet = new HashSet<>(tags);
                tagSet.forEach(tag -> {
                            Set<Recipe> recipes = tag.getRecipes();
                            recipes.add(saved);
                            tag.setRecipes(recipes);
                         Tag tagss= tagRepository.save(tag);
                         saved.getTags().add(tagss);
                         recipeRepository.save(saved);

                        }
                );
            }else{
                throw new NullPointerException();
            }
        }
        return toResponseDto(saved);
    }
        public RecipeResponseDto getRecipe(Long id){
        return toResponseDto(recipeRepository.findById(id).orElseThrow(()->new RecipeNotFoundException(id)));

        }

        public RecipeResponseDto updateRecipe(Long id, RecipeDTO recipeDTO){
        Recipe recipe= recipeRepository.findById(id).orElseThrow(()->new RecipeNotFoundException(id));
        recipe.setTitle(recipeDTO.getTitle());
        recipe.setCokingTime(recipeDTO.getCookingTime());
        recipe.setImageUrl(recipeDTO.getImageUrl());
        recipe.setInstructions(recipeDTO.getInstructions());
        return toResponseDto(recipeRepository.save(recipe));

        }

  public void deleteRecipe(Long id){
        Recipe recipe= recipeRepository.findById(id).orElseThrow(()->new RecipeNotFoundException(id));
        recipeRepository.deleteById(id);

  }
public Set<RecipeResponseDto> getAllRecipes(){
        List<Recipe> recipes=recipeRepository.findAll();
    List<RecipeResponseDto> recipeResponse=recipes.stream().map(this::toResponseDto).toList();
    Set<RecipeResponseDto> recipesSet=new HashSet<>(recipeResponse);
    return recipesSet;
}
public Set<RecipeResponseDto> getAllRecipesByIngredients(Set<Long> ingredientIds){
        List<Recipe> teste=recipeRepository.findAll();
        List<Recipe> recitinf=new ArrayList<>();
        teste.forEach(recipe -> {
            Set<Ingredient> ingredients=recipe.getIngredients();

        });

        List<Ingredient> ingredientsList= ingredientRepository.findAllById(ingredientIds);
        if(ingredientsList.size()>0) {
            Set<Ingredient> ingredients = new HashSet<>(ingredientsList);
            List<Recipe> recipes = recipeRepository.findByIngredientsIn(ingredients);
            if(recipes.size()>0){
            List<RecipeResponseDto> recipeResponse = recipes.stream().map(this::toResponseDto).toList();
            Set<RecipeResponseDto> recipesSet = new HashSet<>(recipeResponse);
            return recipesSet;}
            else{
                return new HashSet<RecipeResponseDto>();
            }

        }else
            return new HashSet<RecipeResponseDto>();

}

}