package com.example.demo.controller;

import com.example.demo.Service.CommentService;
import com.example.demo.dto.CommentDto;
import com.example.demo.dto.CommentResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/api/comments")
    public ResponseEntity<CommentResponseDto> createComment(@Valid @RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.createComment(commentDto));

    }
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id){
        commentService.getCommentById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
