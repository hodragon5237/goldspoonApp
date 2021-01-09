package com.project827.backend.model.network.response;

import java.time.LocalDateTime;

import com.project827.backend.model.enumclass.AccountStatus;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountApiResponse {

    private Integer id;

    private String email;

    private String password;
    
    private String name;

    private String incomingPath;

    private AccountStatus status;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;
    
}