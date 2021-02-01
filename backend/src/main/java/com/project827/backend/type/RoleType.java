package com.project827.backend.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum RoleType {

    ADMIN("ADMIN"),
    MEMBER("MEMBER");

    private String value;
}
