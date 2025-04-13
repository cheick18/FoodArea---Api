package com.example.demo.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.CategoryResponseDto;
import com.example.demo.dto.RecipeResponseDto;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.model.Category;
import com.example.demo.model.Recipe;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CategoryService {
private final CategoryRepository categoryRepository;
private final RecipeService recipeService;


    public CategoryService(CategoryRepository categoryRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.recipeService = recipeService;
    }


    public CategoryResponseDto toResponseDto(Category category){
        return new CategoryResponseDto(category.getId(),category.getName(), category.getDescription());

    }

    public Category createCategory(CategoryDto categoryDto){
        Set<Recipe> recipes= new HashSet<>();
        Category savedcategory=new Category();
        savedcategory.setName(categoryDto.getName());
        savedcategory.setRecipes(recipes);
        savedcategory.setDescription(categoryDto.getDescription());


        return categoryRepository.save(savedcategory);
    }
    public CategoryResponseDto getCategoryById(Long id){

        Category category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
        return toResponseDto(category);
    }
    public CategoryResponseDto getCategoryByName(String name){
        Category category=categoryRepository.findByName(name).orElseThrow(()->null);
        CategoryResponseDto categoryResponse=toResponseDto(category);

        return categoryResponse;
    }
    @Transactional
    public void  deleteCategory(Long id){
        Category category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
        categoryRepository.deleteById(id);
    }
    @Transactional
    public CategoryResponseDto updateCategory(Long id,CategoryDto categoryDto){
        Category existingCategory=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));

        existingCategory.setName(categoryDto.getName());
        existingCategory.setDescription(categoryDto.getDescription());
      Category  category=categoryRepository.save(existingCategory);
        CategoryResponseDto categoryResponse=toResponseDto(category);
        return categoryResponse;

    }
    public Set<CategoryResponseDto> getAllCategory(){
        List<Category> categories= categoryRepository.findAll();
        List<CategoryResponseDto>  cats=categories.stream().map(this::toResponseDto).toList();
        Set<CategoryResponseDto> categoriesSet= new HashSet<>(cats);

        return categoriesSet;
    }
    public Set<RecipeResponseDto> getAllRecipeByCategory(Long id){
      Category category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
      Set<RecipeResponseDto > recipeResponse=new HashSet<>();
        if(category.getRecipes()!=null){
            category.getRecipes().forEach(recipe -> {
                recipeResponse.add(recipeService.toResponseDto(recipe));
            });

        }
        return recipeResponse;
    }

}
