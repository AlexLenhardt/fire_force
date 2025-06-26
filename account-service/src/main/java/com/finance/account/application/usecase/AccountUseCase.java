package com.finance.account.application.usecase;

import com.finance.account.infrastructure.persistence.entity.Account;
import com.finance.account.shared.exception.ApiError;


public interface AccountUseCase {
    ApiError create(Account account);
}
