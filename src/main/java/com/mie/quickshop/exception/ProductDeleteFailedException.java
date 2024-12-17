package com.mie.quickshop.exception;

public class ProductDeleteFailedException extends RuntimeException {
    public ProductDeleteFailedException(String message) {
        super(message);
    }
}
