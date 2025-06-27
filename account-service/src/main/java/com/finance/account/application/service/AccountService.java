package com.finance.account.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.finance.account.application.usecase.AccountUseCase;
import static com.finance.account.domain.exception.AccountException.DOCUMENTO_NAO_INFORMADO;
import static com.finance.account.domain.exception.AccountException.EMAIL_NAO_INFORMADO;
import static com.finance.account.domain.exception.AccountException.NOME_NAO_INFORMADO;
import static com.finance.account.shared.exception.ErrorDefinitions.CONTA_NAO_ENCONTRADA;
import com.finance.account.domain.repository.AccountRepository;
import com.finance.account.infrastructure.persistence.entity.Account;
import com.finance.account.shared.exception.ApiError;
import static com.finance.account.shared.exception.ErrorDefinitions.ERRO_DESCONHECIDO;

@Service
class AccountService implements AccountUseCase {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public ApiError create(Account account) {
        try {
            
            String doc = account.getDocument();
            if (doc == null || doc.equals("")) {
                return DOCUMENTO_NAO_INFORMADO;
            }

            String name = account.getName();
            if (name == null || name.equals("")) {
                return NOME_NAO_INFORMADO;
            }

            String email = account.getEmail();
            if (email == null || email.trim().equals("")) {
                return EMAIL_NAO_INFORMADO;
            }

            accountRepository.save(account);

            return new ApiError("", account, HttpStatus.CREATED);
        } catch (Exception e) {
            ERRO_DESCONHECIDO.setMessage(e.toString());
            return ERRO_DESCONHECIDO;
        }
    }

    @Override
    public ApiError get(Account account){
        try {
            String uuid = account.getUUID().toString();
            if (!uuid.trim().equals("")) {
                Account result = accountRepository.getByUUID(account);
                if(result == null){
                    return CONTA_NAO_ENCONTRADA;
                }

                return new ApiError("", result, HttpStatus.ACCEPTED);
            }
            return CONTA_NAO_ENCONTRADA;
        } catch (Exception e) {
            ERRO_DESCONHECIDO.setMessage(e.toString());
            return ERRO_DESCONHECIDO;
        }
    }

}
