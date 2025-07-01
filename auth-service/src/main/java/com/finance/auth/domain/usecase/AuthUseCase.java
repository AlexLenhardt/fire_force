package com.finance.auth.domain.usecase;

import com.finance.auth.infrastructure.persistence.entity.ApiError;
import com.finance.auth.infrastructure.persistence.entity.User;

public interface AuthUseCase {
    ApiError createUser(User user);
}
