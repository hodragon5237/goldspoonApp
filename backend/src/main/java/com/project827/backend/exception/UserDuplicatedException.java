package com.project827.backend.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDuplicatedException extends Exception {


    public UserDuplicatedException(String message) {
        super(message);
    }
}
