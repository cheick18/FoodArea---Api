package com.example.demo.Service;

import com.example.demo.dto.RecipeResponseDto;
import com.example.demo.dto.TagDto;
import com.example.demo.dto.TagResponseDto;
import com.example.demo.exception.TagNotFoundException;
import com.example.demo.model.Comment;
import com.example.demo.model.Recipe;
import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TagService {
    private final TagRepository tagRepository;
    private final  RecipeService recipeService;

    public TagService(TagRepository tagRepository, RecipeService recipeService) {
        this.tagRepository = tagRepository;
        this.recipeService = recipeService;
    }
    public TagResponseDto toResponseDto(Tag tag){
        return new TagResponseDto(tag.getId(), tag.getName());

    }
    public TagResponseDto createTag(TagDto tagDto){
        Set<Recipe> recipes= new HashSet<>();
        Tag tag=new Tag();
        tag.setName(tagDto.getName());
        tag.setRecipes(recipes);
        return toResponseDto(tagRepository.save(tag));
    }
    public Tag getTagById(Long id){
        Tag tag= tagRepository.findById(id).orElseThrow(()->new TagNotFoundException(id));
        return tag;

    }
    public Set<TagResponseDto> getAllTags(){
        List<Tag> tags= tagRepository.findAll();
        List<TagResponseDto> tagsResponse=tags.stream().map(this::toResponseDto).toList();
        Set<TagResponseDto> tagsSet=new HashSet<>(tagsResponse);
        return tagsSet;
    }
    @Transactional
    public TagResponseDto updateTag(Long id,TagDto tagDO){
        Tag tag= tagRepository.findById(id).orElseThrow(()->new TagNotFoundException(id));
        tag.setName(tagDO.getName());
        return toResponseDto(tagRepository.save(tag));
    }
    public void deleteTag(Long id){
        Tag tag= tagRepository.findById(id).orElseThrow(()->new TagNotFoundException(id));
        tagRepository.deleteById(id);
    }
    public Set<RecipeResponseDto> getAllRecipesByTagId(Long id){
        Tag tag= tagRepository.findById(id).orElseThrow(()->new TagNotFoundException(id));
        Set<Recipe> recipes= tag.getRecipes();
        Set<RecipeResponseDto > reciperesponse=new HashSet<>();
        if(recipes!=null){
            recipes.forEach(recipe -> {
                reciperesponse.add(recipeService.toResponseDto(recipe));
            });

        }

        return reciperesponse;
    }
}
