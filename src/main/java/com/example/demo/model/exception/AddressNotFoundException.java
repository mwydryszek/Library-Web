package com.example.demo.model.exception;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException() {
        super("Address not found");
    }

}
