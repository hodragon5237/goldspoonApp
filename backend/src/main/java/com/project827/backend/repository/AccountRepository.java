package com.project827.backend.repository;

import com.project827.backend.model.entity.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>{

    Optional<Account> findByName(String name);
    Optional<Account> findByEmail(String email);
}