package com.example.demo.model.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException() {
        super("Book not found");
    }
}
