SHOW DATABASES;

USE users;

SHOW TABLES;

DESCRIBE Users;

SELECT * FROM Users;

DROP TABLE IF EXISTS Users;

DELETE FROM Users WHERE id = 4;

CREATE TABLE IF NOT EXISTS Users(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
    name VARCHAR (255),
    lastname VARCHAR (255),
    age VARBINARY(255)
);





