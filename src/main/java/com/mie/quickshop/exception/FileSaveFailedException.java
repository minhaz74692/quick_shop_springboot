package com.mie.quickshop.exception;

public class FileSaveFailedException extends RuntimeException{
    public FileSaveFailedException(String message){
        super(message);
    }
}
