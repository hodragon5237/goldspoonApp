package com.project827.backend.service;

import com.project827.backend.dto.AccountDto;
import com.project827.backend.model.entity.Account;
import com.project827.backend.model.network.request.AccountApiRequest;
import com.project827.backend.repository.AccountRepository;
import com.project827.backend.type.RoleType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> optional = accountRepository.findByName(username);
        Account account = optional.get();

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (account != null) {
            authorities.add(new SimpleGrantedAuthority(RoleType.MEMBER.getValue()));
        }

        return new User(account.getName(), account.getPassword(), authorities);
    }
}
