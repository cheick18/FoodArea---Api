package com.example.demo.exception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(Long id) {
        super("Category with " + id + "Not found");
    }
}
