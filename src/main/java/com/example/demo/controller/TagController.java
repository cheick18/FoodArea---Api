package com.example.demo.controller;

import com.example.demo.Service.TagService;
import com.example.demo.dto.RecipeResponseDto;
import com.example.demo.dto.TagDto;
import com.example.demo.dto.TagResponseDto;
import com.example.demo.model.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class TagController {
    private final TagService  tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/api/tags")
    public ResponseEntity<TagResponseDto> createTag(@Valid @RequestBody TagDto tagDto){
        return ResponseEntity.ok(tagService.createTag(tagDto));
    }
    @GetMapping("/api/tags/{id}")
    public ResponseEntity<Tag> getTag(@PathVariable Long id){
        return ResponseEntity.ok(tagService.getTagById(id));
    }
    @GetMapping("/api/tags")
    public ResponseEntity<Set<TagResponseDto>> getAllTags(){
        return ResponseEntity.ok(tagService.getAllTags());
    }
    @DeleteMapping("/api/tags/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/api/tags/{id}")
    public ResponseEntity<TagResponseDto> updateTag(@PathVariable Long id, @RequestBody TagDto tagDto){
        return ResponseEntity.ok(tagService.updateTag(id,tagDto));

    }
    @GetMapping("/api/tags/{id}/recipes")
    public ResponseEntity<Set<RecipeResponseDto>> getALLrecipesByTagId(@PathVariable Long id){
        return ResponseEntity.ok(tagService.getAllRecipesByTagId(id));

    }
}
