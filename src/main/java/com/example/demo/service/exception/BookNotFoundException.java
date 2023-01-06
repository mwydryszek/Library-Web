package com.example.demo.service.exception;

public class BookNotFoundException extends RuntimeException{

    public BookNotFoundException() {
        super("Book not found");
    }
}
