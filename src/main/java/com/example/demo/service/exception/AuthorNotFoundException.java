package com.example.demo.service.exception;

public class AuthorNotFoundException extends RuntimeException{


    public AuthorNotFoundException() {
        super("Author not found");
    }
}
