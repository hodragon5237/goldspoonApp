package com.project827.backend.repository;

import java.time.LocalDateTime;

import com.project827.backend.BackendApplicationTests;
import com.project827.backend.model.entity.Account;
import com.project827.backend.model.enumclass.AccountStatus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// @DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepositoryTest extends BackendApplicationTests{

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void create(){
        String email = "abcd@gmail.com";
        String password = "abcd123";
        String name = "James";
        String incomingPath = "KaKaO";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        AccountStatus status = AccountStatus.REGISTERED;

        Account account = Account.builder()
                        .email(email)
                        .password(password)
                        .name(name)
                        .incomingPath(incomingPath)
                        .registeredAt(registeredAt)
                        .createdAt(createdAt)
                        .status(status)
                        .build();
        
        Account newAccount = accountRepository.save(account);
        Assertions.assertNotNull(newAccount);
    }
    
}