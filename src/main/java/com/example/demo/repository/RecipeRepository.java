package com.example.demo.repository;

import com.example.demo.model.Ingredient;
import com.example.demo.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

public interface RecipeRepository extends JpaRepository<Recipe,Long>{

    @Query("SELECT r FROM Recipe r JOIN r.ingredients i WHERE i IN :ingredients")
    List<Recipe> findByIngredientsIn(Set<Ingredient> ingredients);


    @Query("SELECT DISTINCT r FROM Recipe r JOIN r.ingredients i WHERE i.id IN :ingredientIds")
    Set<Recipe> findByAnyIngredient(@Param("ingredientIds") Set<Long> ingredientIds);
    @Query("SELECT r FROM Recipe r JOIN r.ingredients i " +
            "WHERE i.id IN :ingredientIds " +
            "GROUP BY r.id " +
            "HAVING COUNT(DISTINCT i.id) = :size")
    Set<Recipe> findByAllIngredients(@Param("ingredientIds") Set<Long> ingredientIds,
                                     @Param("size") long size);
    @Query("SELECT DISTINCT r FROM Recipe r JOIN r.ingredients i WHERE i.id IN :ingredientIds")
    Set<Recipe> findWithSomeIngredients(@Param("ingredientIds") Set<Long> ingredientIds);



}
