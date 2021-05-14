package com.vodafone.iot.exception;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandlers {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleValidationErrors(ValidationException ex){
        return new ResponseEntity<>(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);

    }
    
}
