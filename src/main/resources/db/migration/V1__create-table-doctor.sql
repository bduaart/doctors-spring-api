create table medicos(
    id bigint not null auto_increment,
    name varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    expertise varchar(100) not null,
    street varchar(100) not null,
    district varchar(100) not null,
    cep varchar(9) not null,
    complement varchar(100),
    state varchar(100) not null,
    city varchar(100) not null,
    primary key(id)
);