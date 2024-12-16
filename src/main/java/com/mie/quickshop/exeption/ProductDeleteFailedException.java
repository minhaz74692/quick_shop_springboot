package com.mie.quickshop.exeption;

public class ProductDeleteFailedException extends RuntimeException {
    public ProductDeleteFailedException(String message) {
        super(message);
    }
}
