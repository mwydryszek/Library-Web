package com.example.demo.model.exception;

public class AuthorNotFoundException extends RuntimeException{


    public AuthorNotFoundException() {
        super("Author not found");
    }
}
