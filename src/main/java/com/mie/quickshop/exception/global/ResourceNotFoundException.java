package com.mie.quickshop.exception.global;

public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
