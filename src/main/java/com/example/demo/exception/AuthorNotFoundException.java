package com.example.demo.exception;

public class AuthorNotFoundException extends RuntimeException{


    public AuthorNotFoundException() {
        super("Author not found");
    }
}
