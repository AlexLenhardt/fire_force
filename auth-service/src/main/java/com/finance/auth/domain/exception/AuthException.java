package com.finance.auth.domain.exception;

import org.springframework.http.HttpStatus;

import com.finance.auth.infrastructure.persistence.entity.ApiError;

public class AuthException {
    public static final ApiError ERRO_DESCONHECIDO =
        new ApiError("ERRO_DESCONHECIDO", "Erro não registrado", HttpStatus.BAD_REQUEST);
}