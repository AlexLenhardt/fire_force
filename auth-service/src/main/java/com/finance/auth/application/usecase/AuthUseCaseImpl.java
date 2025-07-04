package com.finance.auth.application.usecase;

import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import static com.finance.auth.domain.exception.AuthException.ERRO_DESCONHECIDO;
import com.finance.auth.domain.repository.AuthRepository;
import com.finance.auth.domain.usecase.AuthUseCase;
import com.finance.auth.infrastructure.persistence.entity.ApiError;
import com.finance.auth.infrastructure.persistence.entity.User;
import com.finance.auth.infrastructure.security.PasswordEncoderImpl;

@Service
public class AuthUseCaseImpl implements AuthUseCase {

    private final AuthRepository authRepository;

    public AuthUseCaseImpl(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    @Override
    public ApiError createUser(User user) {
        try {
            PasswordEncoderImpl encoder = new PasswordEncoderImpl();

            ApiError userError = user.AuthRules();
            if (userError != null) {
                return userError;
            }

            boolean userExist = false;
            if (user.getUuid() != null) {
                userExist = authRepository.getUser(user) != null;
            }
            user.setPasswordHash(encoder.hash(user.getPassword()));
            
            Exception e;
            if (userExist) {
                e = authRepository.updateUser(user);
            } else {
                user.setUuid(UUID.randomUUID());
                e = authRepository.createUser(user);
            }

            if (e != null) {
                ERRO_DESCONHECIDO.setMessage(e.toString());
                return ERRO_DESCONHECIDO;
            }

            user.setPassword(null);
            user.setPasswordHash(null);
        } catch (Exception e) {
            ERRO_DESCONHECIDO.setMessage(e.toString());
            return ERRO_DESCONHECIDO;
        }

        return new ApiError("", user, HttpStatus.ACCEPTED);
    }
}
