package com.example.demo.Service;

import com.example.demo.dto.CategoryDto;
import com.example.demo.dto.CategoryResponseDto;
import com.example.demo.exception.CategoryNotFoundException;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class CategoryService {
private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDto createCategory(CategoryDto categoryDto){
        Category category= CategoryMapper.INSTANCE.toEntity(categoryDto);

        return CategoryMapper.INSTANCE.toResponseDto(categoryRepository.save(category));
    }
    public CategoryResponseDto getCategoryById(Long id){
        Category category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
        return CategoryMapper.INSTANCE.toResponseDto(category);
    }
    public CategoryResponseDto getCategoryByName(String name){
        Category category=categoryRepository.findByName(name).orElseThrow(()->null);
        return CategoryMapper.INSTANCE.toResponseDto(category);
    }
    @Transactional
    public void  deleteCategory(Long id){
        Category category=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
        categoryRepository.deleteById(id);
    }
    @Transactional
    public CategoryResponseDto updateCategory(Long id,CategoryDto categoryDto){
        Category existingCategory=categoryRepository.findById(id).orElseThrow(()->new CategoryNotFoundException(id));
        Category category= CategoryMapper.INSTANCE.toEntity(categoryDto);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        existingCategory.setRecipes(category.getRecipes());
        return CategoryMapper.INSTANCE.toResponseDto(categoryRepository.save(existingCategory));

    }
    public Set<CategoryResponseDto> getAllCategory(){
        Set<Category> categories= (Set<Category>) categoryRepository.findAll();

        return CategoryMapper.INSTANCE.toResponseDtoSet(categories);
    }
}
