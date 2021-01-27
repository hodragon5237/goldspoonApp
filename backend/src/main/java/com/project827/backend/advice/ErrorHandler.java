package com.project827.backend.advice;

import com.project827.backend.exception.UserDuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UserDuplicatedException.class)
    public ResponseEntity<Object> userDuplicatedExceptionHandler(UserDuplicatedException e) {
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(e.getMessage());
    }
}
