package com.finance.auth.infrastructure.persistence.entity;

import org.springframework.http.HttpStatus;

public class ApiError {

    private String code;      
    private Object message;   
    private HttpStatus status;

    public ApiError(String code, Object message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    // Getters & Setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}