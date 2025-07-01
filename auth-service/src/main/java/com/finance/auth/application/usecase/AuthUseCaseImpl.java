package com.finance.auth.application.usecase;

import org.springframework.stereotype.Service;

import com.finance.auth.domain.usecase.AuthUseCase;
import com.finance.auth.infrastructure.persistence.entity.ApiError;
import com.finance.auth.infrastructure.persistence.entity.User;

@Service
public class AuthUseCaseImpl implements AuthUseCase {

    @Override
    public ApiError createUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}