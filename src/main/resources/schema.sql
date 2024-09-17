CREATE TABLE "USER"(
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(200),
    password VARCHAR(100),
    created TIMESTAMP,
    modified TIMESTAMP,
    last_login TIMESTAMP,
    is_active SMALLINT
);

CREATE TABLE "PHONE"(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id VARCHAR(50),
    number VARCHAR(100),
    city_code VARCHAR(100),
    country_code VARCHAR(100),
    CONSTRAINT fk_user_phone FOREIGN KEY (user_id) REFERENCES "USER"(id)
);