package com.finance.account.infrastructure.persistence.repository;

import java.time.LocalDateTime;
import java.util.UUID;
import static java.util.UUID.randomUUID;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Repository;

import com.finance.account.domain.repository.AccountRepository;
import com.finance.account.infrastructure.persistence.entity.Account;

@Repository
public class AccountRepositoryJooqImpl implements AccountRepository {

    private final DSLContext dsl;

    public AccountRepositoryJooqImpl(DSLContext dsl) {
        this.dsl = dsl;
    }

    Table<?> accountTable = DSL.table("account");
    Field<UUID> uuidField = DSL.field("uuid", UUID.class);
    Field<String> nameField = DSL.field("name", String.class);
    Field<String> documentField = DSL.field("document", String.class);
    Field<String> emailField = DSL.field("email", String.class);

    @Override
    public Account save(Account account) {

        Integer numberOfData = 0;
        if (account.getUUID() != null && !account.getUUID().toString().trim().equals("")) {
            if (getByUUID(account) != null) {
                numberOfData = 1;
            }
        }

        if (numberOfData == 0) {
            UUID uuid = randomUUID();
            dsl.insertInto(accountTable)
                    .set(uuidField, uuid)
                    .set(nameField, account.getName())
                    .set(documentField, account.getDocument())
                    .set(emailField, account.getEmail())
                    .execute();

            account.setUUID(uuid);

            return account;
        } else {
            dsl.update(accountTable)
                    .set(nameField, account.getName())
                    .set(documentField, account.getDocument())
                    .set(emailField, account.getEmail())
                    .where(uuidField.eq(account.getUUID()))
                    .execute();

            return account;
        }
    }

    @Override
    public Account getByUUID(Account account) {
        Record result = dsl.select()
                .from(accountTable)
                .where(uuidField.eq(account.getUUID()))
                .fetchOne();

        if (result == null) {
            return null;
        }

        return toAccount(result);
    }

    public Account toAccount(Record record) {
        return new Account(
                record.get("uuid", UUID.class),
                record.get("name", String.class),
                record.get("document", String.class),
                record.get("email", String.class),
                record.get("status_code", Integer.class),
                record.get("updated_at", LocalDateTime.class),
                record.get("created_at", LocalDateTime.class)
        );
    }
}
