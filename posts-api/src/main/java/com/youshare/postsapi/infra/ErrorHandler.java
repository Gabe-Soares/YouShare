package com.youshare.postsapi.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handle400(MethodArgumentNotValidException e) {
        var errorList = e.getFieldErrors();
        return ResponseEntity.badRequest().body(errorList.stream().map(FieldValidationError::new).toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handle404() {
        return ResponseEntity.notFound().build();
    }

    // Record for mapping field errors when handling responses 400.
    private record FieldValidationError(String field, String message) {
        public FieldValidationError(FieldError e) {this(e.getField(), e.getDefaultMessage());}
    }
}
