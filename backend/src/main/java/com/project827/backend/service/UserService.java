package com.project827.backend.service;

import com.project827.backend.dto.AccountDto;
import com.project827.backend.model.entity.Account;
import com.project827.backend.model.entity.UserDetailsImpl;
import com.project827.backend.model.network.request.AccountApiRequest;
import com.project827.backend.repository.AccountRepository;
import com.project827.backend.type.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    public Account login(AccountDto request) {

        Optional<Account> optional = accountRepository.findByEmail(request.getEmail());

        if (optional.isEmpty()) {
            throw new UsernameNotFoundException(request.getEmail());
        } else {
            Account account = optional.get();

            if (account.getPassword().equals(
                    new BCryptPasswordEncoder().encode(request.getPassword()))) {
                return account;
            } else {
                return null;
            }
        }
    }


    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        return UserDetailsImpl.build(user);
    }
}
