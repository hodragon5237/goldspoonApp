package com.project827.backend.model.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.project827.backend.model.enumclass.AccountStatus;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Account {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    private String name;

    private String incomingPath;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;  // REGISTERED / UNREGISTERED

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
    
}