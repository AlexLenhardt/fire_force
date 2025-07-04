package com.finance.auth.domain.exception;

import org.springframework.http.HttpStatus;

import com.finance.auth.infrastructure.persistence.entity.ApiError;

public class AuthException {
    public static final ApiError ERRO_DESCONHECIDO =
        new ApiError("ERRO_DESCONHECIDO", "Erro não registrado", HttpStatus.BAD_REQUEST);
    
    public static final ApiError EMAIL_NAO_INFORMADO =
        new ApiError("EMAIL_NAO_INFORMADO", "E-mail não informado", HttpStatus.BAD_REQUEST);
    
    public static final ApiError NOME_NAO_INFORMADO =
        new ApiError("NOME_NAO_INFORMADO", "Nome não informado", HttpStatus.BAD_REQUEST);
    
    public static final ApiError SENHA_NAO_INFORMADA =
        new ApiError("SENHA_NAO_INFORMADO", "Senha não informada", HttpStatus.BAD_REQUEST);
    
    public static final ApiError DOCUMENTO_NAO_INFORMADO =
        new ApiError("DOCUMENTO_NAO_INFORMADO", "Documento não informado", HttpStatus.BAD_REQUEST);
}