package com.project827.backend.advice;

import com.project827.backend.exception.UserDuplicatedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UserDuplicatedException.class)
    public String userDuplicatedExceptionHandler() {
        return "이미 가입된 회원이 있습니다.";
    }
}
