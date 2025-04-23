package com.example.demo.exception;

public class LoginAlreadyExistsException extends RuntimeException {
    public LoginAlreadyExistsException(String login) {
        super("Le login '" + login + "' est déjà utilisé.");
    }
}
