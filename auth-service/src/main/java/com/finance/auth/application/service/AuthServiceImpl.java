package com.finance.auth.application.service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.finance.auth.domain.exception.AuthException.ERRO_DESCONHECIDO;
import com.finance.auth.domain.service.AuthService;
import com.finance.auth.domain.usecase.AuthUseCase;
import com.finance.auth.infrastructure.persistence.entity.User;
import com.finance.auth.infrastructure.persistence.entity.ApiError;

@RestController
@RequestMapping("/auth")
class AuthServiceImpl implements AuthService {
    private final AuthUseCase authUseCase;

    public AuthServiceImpl(AuthUseCase authUseCase) {
        this.authUseCase = authUseCase;
    }

    @Override
    @PostMapping
    public ApiError createUser(User user) {
        authUseCase.createUser(user);
        
        return ERRO_DESCONHECIDO;
    }
}