package com.finance.account.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.finance.account.application.usecase.AccountUseCase;
import static com.finance.account.domain.exception.AccountException.DOCUMENTO_NAO_INFORMADO;
import static com.finance.account.domain.exception.AccountException.NOME_NAO_INFORMADO;
import static com.finance.account.domain.exception.AccountException.EMAIL_NAO_INFORMADO;
import com.finance.account.infrastructure.persistence.entity.Account;
import com.finance.account.shared.exception.ApiError;
import static com.finance.account.shared.exception.ErrorDefinitions.ERRO_DESCONHECIDO;

@Service
class AccountService implements AccountUseCase {

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
            if (email == null || email.equals("")) {
                return EMAIL_NAO_INFORMADO;
            }

            String id = account.getId();
            if (id == null) {
                
            }

            return new ApiError("", account, HttpStatus.CREATED);
        } catch (Exception e) {
            ERRO_DESCONHECIDO.setMessage(e.toString());
            return ERRO_DESCONHECIDO;
        }
    }

}
