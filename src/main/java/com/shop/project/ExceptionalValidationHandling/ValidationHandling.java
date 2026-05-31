package com.shop.project.ExceptionalValidationHandling;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import java.util.Map;
import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class ValidationHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
    Map<String,String> errors=new HashMap<>();
    ex.getBindingResult().getAllErrors().forEach(error->{
        FieldError fieldName=(FieldError) error;
        String errorMessage=error.getDefaultMessage();
        errors.put(fieldName.getField(),errorMessage);
    });
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
}    
}
