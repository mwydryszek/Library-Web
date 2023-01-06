package com.example.demo.service.exception;

public class RentNotFoundException extends RuntimeException{

    public RentNotFoundException() {
        super("Rent not found");
    }

}
