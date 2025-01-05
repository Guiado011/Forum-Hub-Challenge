create table usuarios (
    id bigint not null auto_increment primary key,
    login varchar(255) not null unique,
    senha varchar(255) not null
);