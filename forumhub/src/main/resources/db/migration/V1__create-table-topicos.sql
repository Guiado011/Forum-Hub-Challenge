create table topicos (
    id bigint not null auto_increment primary key,
    titulo varchar(255) not null,
    mensagem varchar(255) not null,
    status varchar(255) not null,
    data_criacao datetime not null,
    autor varchar(255) not null,
    curso varchar(255) not null
);