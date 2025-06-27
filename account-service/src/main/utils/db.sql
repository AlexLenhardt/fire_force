CREATE TABLE account (
    uuid UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    document VARCHAR(20),
    email VARCHAR(100),
    status_code INTEGER default 0,
    updated_at TIMESTAMP default now(),
    created_at TIMESTAMP default now()
);