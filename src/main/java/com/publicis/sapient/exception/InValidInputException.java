package com.publicis.sapient.exception;

public class InValidInputException extends RuntimeException{

    private String message;

    public InValidInputException(String message) {
        super(message);
        this.message = message;
    }
}
