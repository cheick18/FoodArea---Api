package com.example.demo.repository;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface RecipeRepository extends JpaRepository<Recipe,Long>{

    @Query("SELECT r FROM Recipe r JOIN r.ingredients i WHERE i IN :ingredients")
    Set<Recipe> findByIngredientsIn(Set<Ingredient> ingredients);

}
