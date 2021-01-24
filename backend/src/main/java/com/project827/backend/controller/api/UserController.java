package com.project827.backend.controller.api;

import com.project827.backend.dto.AccountDto;
import com.project827.backend.model.entity.Account;
import com.project827.backend.service.AccountApiLogicService;
import com.project827.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserDetails loginChecker(@RequestBody AccountDto request) {

        Account account = userService.login(request);

        if (account != null) {
            UserDetails userInfo = userService.loadUserByUsername(account.getName());
            return userInfo;
        }

        return null;
    }
}
