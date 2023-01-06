package com.example.demo.model.exception;

public class RentNotFoundException extends RuntimeException{

    public RentNotFoundException() {
        super("Rent not found");
    }

}
