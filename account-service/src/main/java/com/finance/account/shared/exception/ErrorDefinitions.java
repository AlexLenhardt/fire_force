package com.finance.account.shared.exception;

import org.springframework.http.HttpStatus;

public class ErrorDefinitions {

    public static final ApiError SALDO_INSUFICIENTE =
        new ApiError("SALDO_INSUFICIENTE", "Saldo insuficiente", HttpStatus.UNPROCESSABLE_ENTITY);

    public static final ApiError CONTA_NAO_ENCONTRADA =
        new ApiError("CONTA_NAO_ENCONTRADA", "Conta não encontrada", HttpStatus.NOT_FOUND);

    public static final ApiError ACESSO_NAO_AUTORIZADO =
        new ApiError("ACESSO_NAO_AUTORIZADO", "Acesso não autorizado", HttpStatus.UNAUTHORIZED);

    public static final ApiError ERRO_DESCONHECIDO =
        new ApiError("ERRO_DESCONHECIDO", "Erro desconhecido", HttpStatus.INTERNAL_SERVER_ERROR);
}