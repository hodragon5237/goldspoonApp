package com.project827.backend.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDuplicatedException extends Exception {


    public UserDuplicatedException(String message) {
        super("이미 가입한 정보가 있습니다.");
    }
}
