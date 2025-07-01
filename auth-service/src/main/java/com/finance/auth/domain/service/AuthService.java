package com.finance.auth.domain.service;

import com.finance.auth.infrastructure.persistence.entity.ApiError;
import com.finance.auth.infrastructure.persistence.entity.User;

public interface AuthService {
    ApiError createUser(User user);
}
