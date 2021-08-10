package com.publicis.sapient.exception;

import org.springframework.http.HttpStatus;

public class RestRuntimeException extends RuntimeException{

    private String message;
    private HttpStatus httpStatus;

    public RestRuntimeException(String message,HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }
    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
