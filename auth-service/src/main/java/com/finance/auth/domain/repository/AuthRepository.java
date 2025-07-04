package com.finance.auth.domain.repository;

import com.finance.auth.infrastructure.persistence.entity.User;

public interface AuthRepository {
    User getUser(User user);
    Exception createUser(User user);
    Exception updateUser(User user);
}
