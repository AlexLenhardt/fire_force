package com.finance.auth.domain.service;

import org.springframework.http.ResponseEntity;

import com.finance.auth.infrastructure.persistence.entity.ApiError;
import com.finance.auth.infrastructure.persistence.entity.User;

public interface AuthService {
    ResponseEntity<ApiError> createUser(User user);
}
