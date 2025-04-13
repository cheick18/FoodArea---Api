package com.example.demo.exception;

public class TagNotFoundException extends RuntimeException {
    public TagNotFoundException(Long id){
        super("Tag with"+id+"not found");
    }

}
