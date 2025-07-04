package com.finance.auth.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import static com.finance.auth.domain.exception.AuthException.EMAIL_NAO_INFORMADO;
import static com.finance.auth.domain.exception.AuthException.NOME_NAO_INFORMADO;
import static com.finance.auth.domain.exception.AuthException.SENHA_NAO_INFORMADA;
import static com.finance.auth.domain.exception.AuthException.DOCUMENTO_NAO_INFORMADO;

public class User {

    UUID uuid;
    String name;
    String email;
    String document;
    String password;
    String passwordHash;
    Integer statusCode;
    LocalDateTime updatedAt;
    LocalDateTime createdAt;

    // Construtor
    public User(
            UUID uuid,
            String name,
            String email,
            String document,
            String password,
            String passwordHash,
            Integer statusCode,
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updatedAt,
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime createdAt
    ) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.document = document;
        this.password = password;
        this.passwordHash = passwordHash;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    public ApiError AuthRules() {
        String email = this.getEmail();
        String name = this.getName();
        String pass = this.getPassword();
        String doc = this.getDocument();

        if (email == null || email.trim().equals("")) {
            return EMAIL_NAO_INFORMADO;
        }

        if (name == null || name.trim().equals("")) {
            return NOME_NAO_INFORMADO;
        }

        if (pass == null || pass.trim().equals("")) {
            return SENHA_NAO_INFORMADA;
        }

        if (doc == null || doc.trim().equals("")) {
            return DOCUMENTO_NAO_INFORMADO;
        }

        return null;
    }

    //Getters
    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDocument() {
        return document;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    //Setters
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}
