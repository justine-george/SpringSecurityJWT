CREATE TABLE `user`
(
    id         BINARY(16) PRIMARY KEY NOT NULL,
    first_name VARCHAR(255)           NOT NULL,
    last_name  VARCHAR(255)           NOT NULL,
    email      VARCHAR(255)           NOT NULL UNIQUE,
    password   VARCHAR(255)           NOT NULL,
    role       ENUM ('USER', 'ADMIN') NOT NULL DEFAULT 'USER'
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;