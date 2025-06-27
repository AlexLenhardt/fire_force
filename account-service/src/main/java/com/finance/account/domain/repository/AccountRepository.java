package com.finance.account.domain.repository;

import com.finance.account.infrastructure.persistence.entity.Account;

public interface AccountRepository {
    Account save(Account account);
    Account getByUUID(Account account);
}