package com.finance.account.infrastructure.persistence.entity;

import java.time.LocalDateTime;

public class Account {

    private String id;
    private String name;
    private String document;
    private String email;
    private Integer statusCode;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    // Construtor
    public Account(
        String id,
        String name,
        String document,
        String email,
        Integer statusCode,
        LocalDateTime updatedAt,
        LocalDateTime createdAt
    ) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.email = email;
        this.statusCode = statusCode;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
    }

    // Getters
    public String getId() {
        return id;
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
    public void setId(String id) {
        this.id = id;
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
