CREATE TABLE users (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(50) NOT NULL,
                        email VARCHAR(50) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL,
                        datecreate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
                        role VARCHAR(50) NOT NULL
)