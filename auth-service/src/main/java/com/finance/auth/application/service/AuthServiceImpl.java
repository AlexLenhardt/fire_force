package com.finance.auth.application.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.finance.auth.domain.service.AuthService;
import com.finance.auth.domain.usecase.AuthUseCase;
import com.finance.auth.infrastructure.persistence.entity.ApiError;
import com.finance.auth.infrastructure.persistence.entity.User;

@RestController
@RequestMapping("/auth")
class AuthServiceImpl implements AuthService {
    private final AuthUseCase authUseCase;

    public AuthServiceImpl(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<ApiError> createUser(@RequestBody User user) {
        ApiError r = authUseCase.createUser(user);

        return ResponseEntity.status(r.getStatus()).body(r);
    }
}