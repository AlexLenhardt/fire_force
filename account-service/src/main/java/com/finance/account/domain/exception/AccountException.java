package com.finance.account.domain.exception;

import org.springframework.http.HttpStatus;

import com.finance.account.shared.exception.ApiError;

public class AccountException {
    public static final ApiError DOCUMENTO_NAO_INFORMADO =
        new ApiError("DOCUMENTO_NAO_INFORMADO", "Documento não informado", HttpStatus.BAD_REQUEST);
    
    public static final ApiError NOME_NAO_INFORMADO =
        new ApiError("NOME_NAO_INFORMADO", "Nome não informado", HttpStatus.BAD_REQUEST);
    
    public static final ApiError EMAIL_NAO_INFORMADO =
        new ApiError("EMAIL_NAO_INFORMADO", "E-mail não informado", HttpStatus.BAD_REQUEST);
}