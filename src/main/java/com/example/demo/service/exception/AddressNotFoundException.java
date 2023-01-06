package com.example.demo.service.exception;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException() {
        super("Address not found");
    }

}
