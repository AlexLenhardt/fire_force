CREATE TABLE account (
    uuid UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    document VARCHAR(20),
    email VARCHAR(100),
    status_code INTEGER,
    updated_at TIMESTAMP,
    created_at TIMESTAMP
);