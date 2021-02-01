package com.project827.backend.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.project827.backend.exception.UserDuplicatedException;
import com.project827.backend.model.entity.Account;
import com.project827.backend.model.enumclass.AccountStatus;
import com.project827.backend.model.network.Header;
import com.project827.backend.model.network.request.AccountApiRequest;
import com.project827.backend.model.network.response.AccountApiResponse;

import com.project827.backend.repository.AccountRepository;
import com.project827.backend.type.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountApiLogicService extends BaseService<AccountApiRequest, AccountApiResponse, Account> {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public Header<AccountApiResponse> create(Header<AccountApiRequest> request) throws UserDuplicatedException {
        AccountApiRequest accountApiRequest = request.getData();

        Optional<Account> optional = accountRepository.findByEmail(accountApiRequest.getEmail());

        if (optional.isPresent()) {
            throw new UserDuplicatedException();
        }

        Account account = Account.builder()
                        .email(accountApiRequest.getEmail())
                        .password(new BCryptPasswordEncoder().encode(accountApiRequest.getPassword()))
                        .name(accountApiRequest.getName())
                        .incomingPath(accountApiRequest.getIncomingPath())
                        .status(AccountStatus.REGISTERED)
                        .registeredAt(LocalDateTime.now())
                        .createdAt(LocalDateTime.now())
                        .build();
        Account newAccount = baseRepository.save(account);

        return Header.OK(response(newAccount));
    }

    @Override
    public Header<AccountApiResponse> read(Long id) {
        
        return baseRepository.findById(id)
                .map(account -> response(account))
                .map(Header::OK)
                .orElseGet(
                    () -> Header.ERROR("데이터 없음")
                );
    }

    @Override
    public Header<AccountApiResponse> update(Header<AccountApiRequest> request) {

        AccountApiRequest accountApiRequest = request.getData();

        Long privateLong = Long.valueOf(accountApiRequest.getId());
        Optional<Account> optional = baseRepository.findById(privateLong);

        return optional.map(account -> {

            account.setEmail(accountApiRequest.getEmail())
                    .setPassword(accountApiRequest.getPassword())
                    .setName(accountApiRequest.getName())
                    .setIncomingPath(accountApiRequest.getIncomingPath())
                    .setUpdatedAt(LocalDateTime.now())
            ;
            return account;
        })
                .map(account -> baseRepository.save(account))
                .map(account -> response(account))
                .map(Header::OK)
                .orElseGet(
                    () -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        
        Optional<Account> optional = baseRepository.findById(id);

        return optional.map(account ->{
            baseRepository.delete(account);
            return Header.OK();
        })
            .orElseGet(()->Header.ERROR("데이터 없음"));

    }
    
    private AccountApiResponse response(Account account){

        AccountApiResponse accountApiResponse = AccountApiResponse.builder()
                                                .build();

        return accountApiResponse;
    }

}