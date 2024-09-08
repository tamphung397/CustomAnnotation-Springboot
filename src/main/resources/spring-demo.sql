CREATE TABLE users
(
    id       serial primary key,
    username varchar(255),
    password varchar(255),
    email    varchar(255)
)

CREATE TABLE staff
(
    id       serial primary key,
    name     varchar(255),
    position varchar(255),
    salary   int,
    user_id  serial REFERENCES users (id)
)

CREATE TABLE product
(
    id          serial primary key,
    name        varchar(255),
    description varchar(255),
    price       int,
    status      int
)