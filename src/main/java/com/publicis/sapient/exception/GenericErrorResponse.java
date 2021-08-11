package com.publicis.sapient.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class GenericErrorResponse {
    private HttpStatus status;
    private String message;



}
