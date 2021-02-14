package com.project827.backend.controller.api;

import com.project827.backend.controller.CrudController;
import com.project827.backend.model.entity.Account;
import com.project827.backend.model.network.request.AccountApiRequest;
import com.project827.backend.model.network.response.AccountApiResponse;

import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
public class AccountApiController extends CrudController<AccountApiRequest, AccountApiResponse, Account>{
    
}