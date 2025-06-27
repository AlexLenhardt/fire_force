package com.finance.account.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Account {

    private UUID uuid;
    private String name;
    private String document;
    private String email;
    private Integer statusCode;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    // Construtor
    public Account(
        UUID uuid,
        String name,
        String document,
        String email,
        Integer statusCode,
        
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime updatedAt,
        
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdAt
    ) {
        this.uuid = uuid;
        this.name = name;
        this.document = document;
        this.email = email;
        this.statusCode = statusCode;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    // Getters
    public UUID getUUID() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
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

    // Setters
    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
