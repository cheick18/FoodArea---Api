package com.example.demo.Service;

public class Aide {
    /**
     package com.example.demo.service;

     import com.example.demo.dto.RecipeDTO;
     import com.example.demo.dto.RecipeResponseDto;
     import com.example.demo.mapper.RecipeMapper;
     import com.example.demo.model.Category;
     import com.example.demo.model.Comment;
     import com.example.demo.model.Recipe;
     import com.example.demo.model.User;
     import com.example.demo.model.Tag;
     import com.example.demo.repository.CategoryRepository;
     import com.example.demo.repository.RecipeRepository;
     import com.example.demo.repository.TagRepository;
     import com.example.demo.repository.UserRepository;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.stereotype.Service;
     import org.springframework.transaction.annotation.Transactional;

     import java.util.Optional;
     import java.util.Set;

     @Service
     public class RecipeService {

     private final RecipeRepository recipeRepository;
     private final UserRepository userRepository;
     private final CategoryRepository categoryRepository;
     private final TagRepository tagRepository;
     private final RecipeMapper recipeMapper;

     @Autowired
     public RecipeService(RecipeRepository recipeRepository, UserRepository userRepository,
     CategoryRepository categoryRepository, TagRepository tagRepository,
     RecipeMapper recipeMapper) {
     this.recipeRepository = recipeRepository;
     this.userRepository = userRepository;
     this.categoryRepository = categoryRepository;
     this.tagRepository = tagRepository;
     this.recipeMapper = recipeMapper;
     }

     // Créer une nouvelle recette
     @Transactional
     public RecipeResponseDto createRecipe(RecipeDTO recipeDTO) {
     // Récupérer l'utilisateur
     User user = userRepository.findById(recipeDTO.getUserId())
     .orElseThrow(() -> new RuntimeException("User not found"));

     // Récupérer la catégorie
     Category category = categoryRepository.findById(recipeDTO.getCategoryId())
     .orElseThrow(() -> new RuntimeException("Category not found"));

     // Récupérer les tags (facultatifs)
     Set<Tag> tags = tagRepository.findAllById(recipeDTO.getTagIds());

     // Créer la recette à partir du DTO
     Recipe recipe = recipeMapper.toEntity(recipeDTO);
     recipe.setUser(user);
     recipe.setCategory(category);
     recipe.setTags(tags);

     // Sauvegarder la recette
     Recipe savedRecipe = recipeRepository.save(recipe);

     // Mapper la recette sauvegardée en DTO
     return recipeMapper.toResponseDto(savedRecipe);
     }

     // Récupérer une recette par son ID
     public RecipeResponseDto getRecipeById(Long recipeId) {
     Recipe recipe = recipeRepository.findById(recipeId)
     .orElseThrow(() -> new RuntimeException("Recipe not found"));

     // Mapper la recette en DTO pour la réponse
     return recipeMapper.toResponseDto(recipe);
     }

     // Récupérer toutes les recettes
     public Set<RecipeResponseDto> getAllRecipes() {
     Set<Recipe> recipes = (Set<Recipe>) recipeRepository.findAll();

     // Mapper les recettes en DTO
     return recipeMapper.toResponseDtoSet(recipes);
     }

     // Mettre à jour une recette
     @Transactional
     public RecipeResponseDto updateRecipe(Long recipeId, RecipeDTO recipeDTO) {
     // Récupérer la recette existante
     Recipe existingRecipe = recipeRepository.findById(recipeId)
     .orElseThrow(() -> new RuntimeException("Recipe not found"));

     // Mettre à jour les champs de la recette
     existingRecipe.setTitle(recipeDTO.getTitle());
     existingRecipe.setInstructions(recipeDTO.getInstructions());
     existingRecipe.setCookingTime(recipeDTO.getCookingTime());
     existingRecipe.setImageUrl(recipeDTO.getImageUrl());

     // Mettre à jour l'utilisateur, la catégorie et les tags
     User user = userRepository.findById(recipeDTO.getUserId())
     .orElseThrow(() -> new RuntimeException("User not found"));
     Category category = categoryRepository.findById(recipeDTO.getCategoryId())
     .orElseThrow(() -> new RuntimeException("Category not found"));
     Set<Tag> tags = tagRepository.findAllById(recipeDTO.getTagIds());

     existingRecipe.setUser(user);
     existingRecipe.setCategory(category);
     existingRecipe.setTags(tags);

     // Sauvegarder les modifications
     Recipe updatedRecipe = recipeRepository.save(existingRecipe);

     // Mapper la recette mise à jour en DTO
     return recipeMapper.toResponseDto(updatedRecipe);
     }

     // Ajouter un commentaire à une recette
     @Transactional
     public RecipeResponseDto addCommentToRecipe(Long recipeId, Long userId, String content, int rating) {
     // Récupérer la recette
     Recipe recipe = recipeRepository.findById(recipeId)
     .orElseThrow(() -> new RuntimeException("Recipe not found"));

     // Récupérer l'utilisateur
     User user = userRepository.findById(userId)
     .orElseThrow(() -> new RuntimeException("User not found"));

     // Créer un nouveau commentaire
     Comment comment = new Comment();
     comment.setContent(content);
     comment.setRating(rating);
     comment.setUser(user);
     comment.setRecipe(recipe);

     // Sauvegarder le commentaire
     recipe.getComments().add(comment);
     recipeRepository.save(recipe);

     // Mapper la recette avec le commentaire ajouté en DTO
     return recipeMapper.toResponseDto(recipe);
     }
     }

     */
}
