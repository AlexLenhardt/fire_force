package com.finance.auth.infrastructure.persistence.repository;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import org.jooq.Field;
import org.jooq.InsertSetStep;
import org.jooq.Table;
import org.jooq.Record;
import org.springframework.stereotype.Repository;

import com.finance.auth.domain.repository.AuthRepository;
import com.finance.auth.infrastructure.persistence.entity.User;

@Repository
public class AuthRepositoryImpl implements AuthRepository {

    private final DSLContext dsl;

    public AuthRepositoryImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    Table<?> userTable = DSL.table("users");
    Field<UUID> uuidField = DSL.field("uuid", UUID.class);
    Field<String> nameField = DSL.field("name", String.class);
    Field<String> emailField = DSL.field("email", String.class);
    Field<String> documentField = DSL.field("document", String.class);
    Field<String> passwordField = DSL.field("password", String.class);
    Field<Integer> statusField = DSL.field("status_code", Integer.class);
    Field<LocalDateTime> updatedAtField = DSL.field("updated_at", LocalDateTime.class);
    Field<LocalDateTime> createdAtField = DSL.field("created_at", LocalDateTime.class);

    @Override
    public User getUser(User user) {
        Record result = dsl.select()
                .from(userTable)
                .where(uuidField.eq(user.getUuid()))
                .fetchOne();

        if (result == null) {
            return null;
        }

        return toUser(result);
    }

    @Override
    public Exception createUser(User user) {
        try {
            int r = dsl.insertInto(userTable)
                    .columns(uuidField, emailField, nameField, documentField, passwordField, statusField, updatedAtField, createdAtField)
                    .values(user.getUuid(), user.getEmail(), user.getName(), user.getDocument(), user.getPasswordHash(), 0, LocalDateTime.now(), LocalDateTime.now())
                    .execute();

            return null;
        } catch (Exception e) {
            return e;
        }
    }

    @Override
    public Exception updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public User toUser(Record record) {
        return new User(
                record.get("uuid", UUID.class),
                record.get("name", String.class),
                record.get("email", String.class),
                record.get("document", String.class),
                "",
                record.get("passwordHash", String.class),
                record.get("statusCode", Integer.class),
                record.get("updatedAt", LocalDateTime.class),
                record.get("createdAt", LocalDateTime.class)
        );
    }
}
