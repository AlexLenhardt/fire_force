package com.finance.account.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.finance.account.application.usecase.AccountUseCase;
import com.finance.account.infrastructure.persistence.entity.Account;
import com.finance.account.shared.exception.ApiError;

@RestController
@RequestMapping("/accounts")
public class AccountController{
    private final AccountUseCase createAccountUseCase;

    public AccountController(AccountUseCase createAccountUseCase) {
        this.createAccountUseCase = createAccountUseCase;
    }
    
    @PostMapping
    public ResponseEntity<ApiError> createAccount(@RequestBody Account account) {
        ApiError r = createAccountUseCase.create(account);
        return ResponseEntity.status(r.getStatus()).body(r);
    }
}