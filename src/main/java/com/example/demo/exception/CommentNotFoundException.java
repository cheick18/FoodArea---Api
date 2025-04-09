package com.example.demo.exception;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(Long id){
        super("Comment with"+id+"not found");
    }
}
