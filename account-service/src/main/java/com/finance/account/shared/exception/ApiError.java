package com.finance.account.shared.exception;

import org.springframework.http.HttpStatus;

public class ApiError {

    private final String code;       // ex: "DOCUMENTO_NAO_INFORMADO"
    private Object message;    // ex: "Documento não informado"
    private final HttpStatus status; // ex: 400

    public ApiError(String code, Object message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public Object getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setMessage(Object msg){
        this.message = msg;
    }
}