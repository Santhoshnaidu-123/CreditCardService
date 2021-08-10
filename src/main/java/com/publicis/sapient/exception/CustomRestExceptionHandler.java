package com.publicis.sapient.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({RestRuntimeException.class})
    protected ResponseEntity<Object> handleConflict(RestRuntimeException exception, WebRequest webRequest){

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setStatus(exception.getHttpStatus());
        genericErrorResponse.setMessage(exception.getMessage());
        return new ResponseEntity<Object>(
                            genericErrorResponse,
                            new HttpHeaders(),
                            genericErrorResponse.getStatus());
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    protected ResponseEntity<Object> handleConflict(ResourceNotFoundException exception, WebRequest webRequest){

        GenericErrorResponse genericErrorResponse = new GenericErrorResponse();
        genericErrorResponse.setStatus(exception.getHttpStatus());
        genericErrorResponse.setMessage(exception.getMessage());

        return new ResponseEntity<Object>(
                genericErrorResponse,
                new HttpHeaders(),
                genericErrorResponse.getStatus());
    }
}
