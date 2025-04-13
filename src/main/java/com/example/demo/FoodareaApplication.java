package com.example.demo;

import com.example.demo.Service.*;
import com.example.demo.dto.*;
import com.example.demo.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class FoodareaApplication {

	@Bean
	CommandLineRunner initDatabase(CategoryService categoryService,
								   UserService userService,
								   TagService tagService,
								   IngredientService ingredientService,
								   RecipeService recipeService,
								   CommentService commentService) {
		return args -> {
			/* Création des utilisateurs */
			UserDTo user1 = new UserDTo("alice", "password123", AccountType.USER);
			UserDTo user2 = new UserDTo("bob", "secure456", AccountType.USER);
			UserDTo user3 = new UserDTo("admin", "adminpass", AccountType.ADMIN);

			UserResponseDto u1 = userService.createUser(user1);
			UserResponseDto u2 = userService.createUser(user2);
			UserResponseDto u3 = userService.createUser(user3);

			/* Création des catégories */
			CategoryDto cat1 = new CategoryDto("Desserts", "Recettes sucrées pour la fin du repas");
			CategoryDto cat2 = new CategoryDto("Plats principaux", "Repas consistants pour midi ou soir");
			CategoryDto cat3 = new CategoryDto("Entrées", "Légères et appétissantes");

			Category ca1 = categoryService.createCategory(cat1);
			Category ca2 = categoryService.createCategory(cat2);
			Category ca3 = categoryService.createCategory(cat3);

			/* Création des tags */
			TagDto tag1 = new TagDto("Vegan");
			TagDto tag2 = new TagDto("Rapide");
			TagDto tag3 = new TagDto("Sans gluten");

			TagResponseDto ta1 = tagService.createTag(tag1);
			TagResponseDto ta2 = tagService.createTag(tag2);
			TagResponseDto ta3 = tagService.createTag(tag3);

			/* Création des ingrédients */
			IngredientDto ing1 = new IngredientDto("Farine");
			IngredientDto ing2 = new IngredientDto("Œufs");
			IngredientDto ing3 = new IngredientDto("Chocolat noir");
			IngredientDto ing4 = new IngredientDto("Lait d’amande");
			IngredientDto ing5 = new IngredientDto("Avocat");
			IngredientDto ing6 = new IngredientDto("Tomate");
			IngredientDto ing7 = new IngredientDto("Pâtes");
			IngredientDto ing8 = new IngredientDto("Fromage");

			IngredientResponseDto i1 = ingredientService.createIngredient(ing1);
			IngredientResponseDto i2 = ingredientService.createIngredient(ing2);
			IngredientResponseDto i3 = ingredientService.createIngredient(ing3);
			IngredientResponseDto i4 = ingredientService.createIngredient(ing4);
			IngredientResponseDto i5 = ingredientService.createIngredient(ing5);
			IngredientResponseDto i6 = ingredientService.createIngredient(ing6);
			IngredientResponseDto i7 = ingredientService.createIngredient(ing7);
			IngredientResponseDto i8 = ingredientService.createIngredient(ing8);

			/* Création recette 1 : Brownies vegan */
			RecipeDTO recipe1 = new RecipeDTO();
			recipe1.setCategoryId(ca1.getId());
			recipe1.setUserId(u1.getId());
			recipe1.setTitle("Brownies Vegan au Chocolat");
			recipe1.setInstructions("Mélanger farine, chocolat fondu et lait d’amande. Cuire 25 min à 180°C.");
			recipe1.setImageUrl("https://images.unsplash.com/photo-1601979031925-529d5a212b47");
			recipe1.setCookingTime(25);

			List<RecipeIngredientDto> r1Ingredients = new ArrayList<>();
			r1Ingredients.add(new RecipeIngredientDto(i1.getId(), 200)); // Farine
			r1Ingredients.add(new RecipeIngredientDto(i3.getId(), 100)); // Chocolat
			r1Ingredients.add(new RecipeIngredientDto(i4.getId(), 250)); // Lait d'amande
			recipe1.setIngredients(r1Ingredients);

			RecipeResponseDto recipeR1 = recipeService.createRecipe(recipe1);

			/* Création recette 2 : Pâtes à la tomate */
			RecipeDTO recipe2 = new RecipeDTO();
			recipe2.setCategoryId(ca2.getId());
			recipe2.setUserId(u2.getId());
			recipe2.setTitle("Pâtes à la sauce tomate");
			recipe2.setInstructions("Faire cuire les pâtes. Préparer une sauce tomate avec oignons. Mélanger.");
			recipe2.setImageUrl("https://images.unsplash.com/photo-1525755662778-989d0524087e");
			recipe2.setCookingTime(20);

			List<RecipeIngredientDto> r2Ingredients = new ArrayList<>();
			r2Ingredients.add(new RecipeIngredientDto(i6.getId(), 150)); // Tomates
			r2Ingredients.add(new RecipeIngredientDto(i7.getId(), 200)); // Pâtes
			r2Ingredients.add(new RecipeIngredientDto(i8.getId(), 50));  // Fromage
			recipe2.setIngredients(r2Ingredients);

			RecipeResponseDto recipeR2 = recipeService.createRecipe(recipe2);

			/* Création recette 3 : Toast avocat œuf */
			RecipeDTO recipe3 = new RecipeDTO();
			recipe3.setCategoryId(ca3.getId());
			recipe3.setUserId(u1.getId());
			recipe3.setTitle("Toast avocat œuf");
			recipe3.setInstructions("Écraser avocat, cuire œuf au plat, assembler sur toast.");
			recipe3.setImageUrl("https://images.unsplash.com/photo-1555939594-58d7cb561ad1");
			recipe3.setCookingTime(10);

			List<RecipeIngredientDto> r3Ingredients = new ArrayList<>();
			r3Ingredients.add(new RecipeIngredientDto(i5.getId(), 1)); // Avocat
			r3Ingredients.add(new RecipeIngredientDto(i2.getId(), 1)); // Œuf
			recipe3.setIngredients(r3Ingredients);

			RecipeResponseDto recipeR3 = recipeService.createRecipe(recipe3);

			/* Création des commentaires */
			/*
			CommentDto comment1 = new CommentDto("Délicieux et facile à faire !", 5, u2.getId(), recipeR1.getId());
			CommentDto comment2 = new CommentDto("J’ai adoré les brownies, merci !", 4, u3.getId(), recipeR1.getId());
			CommentDto comment3 = new CommentDto("Rapide et savoureux, top !", 5, u1.getId(), recipeR2.getId());

			commentService.createComment(comment1);
			commentService.createComment(comment2);
			commentService.createComment(comment3);
			*/
		};


	}

	public static void main(String[] args) {
		SpringApplication.run(FoodareaApplication.class, args);

	}

}
