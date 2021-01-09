package com.project827.backend.controller.api;

import com.project827.backend.controller.CrudController;
import com.project827.backend.model.entity.Account;
import com.project827.backend.model.network.request.AccountApiRequest;
import com.project827.backend.model.network.response.AccountApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
public class AccountApiController extends CrudController<AccountApiRequest, AccountApiResponse, Account>{
    
}