package com.example.demo.Service;

import com.example.demo.dto.CommentDto;
import com.example.demo.dto.CommentResponseDto;
import com.example.demo.exception.CommentNotFoundException;
import com.example.demo.exception.RecipeNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Comment;
import com.example.demo.model.Recipe;
import com.example.demo.model.AppUser;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.RecipeRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
     private final UserRepository userRepository;
     private final RecipeRepository recipeRepository;
    public CommentService(CommentRepository commentRepository, UserRepository userRepository, RecipeRepository recipeRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }

    public CommentResponseDto toResponseDto(Comment comment){
        return new CommentResponseDto(comment.getId(), comment.getContent(), comment.getRating(), comment.getUser().getLogin());
    }
    public CommentResponseDto createComment(CommentDto commentDto){
        AppUser user=userRepository.findById(commentDto.getUserId()).orElseThrow(()->new UserNotFoundException(commentDto.getUserId()));
        Recipe recipe=recipeRepository.findById(commentDto.getRecipeId()).orElseThrow(()->new RecipeNotFoundException(commentDto.getRecipeId()));
        Comment comment=new Comment();
        comment.setUser(user);
        comment.setRecipe(recipe);
        comment.setRating(commentDto.getRating());
        comment.setContent(commentDto.getContent());
        Comment savedComment=commentRepository.save(comment);
        Set<Comment> commen=recipe.getComments();
        commen.add(savedComment);
        recipe.setComments(commen);
        recipeRepository.save(recipe);

     return toResponseDto(savedComment);
    }
    public CommentResponseDto getCommentById(Long id){
        Comment comment= commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException(id));
        return toResponseDto(comment);
    }
    public Set<Comment> getAllComments(){
        List<Comment> comments=commentRepository.findAll();
        Set<Comment> commentsSet= new HashSet<>(comments);
        return commentsSet;
    }
    public void deleteComment(Long id){
        Comment comment= commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException(id));
        commentRepository.deleteById(id);
    }
    public Comment updateComment(Long id,CommentDto commentDto){
        Comment comment= commentRepository.findById(id).orElseThrow(()->new CommentNotFoundException(id));

        comment.setContent(commentDto.getContent());
        comment.setRating(commentDto.getRating());
        return commentRepository.save(comment);
    }
}
