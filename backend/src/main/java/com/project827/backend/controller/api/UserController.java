package com.project827.backend.controller.api;

import com.project827.backend.dto.AccountDto;
import com.project827.backend.model.entity.Account;
import com.project827.backend.service.AccountApiLogicService;
import com.project827.backend.service.UserService;
import com.project827.backend.utils.Sessions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public RedirectView loginChecker(@RequestBody AccountDto accountDto, HttpServletRequest request) {

        Account account = userService.login(accountDto);

        HttpSession session = request.getSession();

        session.setAttribute(Sessions.SESSION_ID, accountDto);

        Authentication authentication = new UsernamePasswordAuthenticationToken(account.getName(), null);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return new RedirectView("/");
    }
}
