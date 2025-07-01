CREATE TABLE users (
    uuid UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    document VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(200) NOT NULL,
    status_code INTEGER,
    updated_at TIMESTAMP,
    created_at TIMESTAMP
);