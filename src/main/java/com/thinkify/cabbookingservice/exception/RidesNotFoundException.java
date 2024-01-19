package com.thinkify.cabbookingservice.exception;

public class RidesNotFoundException extends RuntimeException {
    public RidesNotFoundException(String message) {
        super(message);
    }
}
