create table medicos(
    id varchar(125) not null unique,
    name varchar(100) not null,
    email varchar(100) not null unique,
    crm varchar(6) not null unique,
    expertise varchar(100) not null,
    address varchar(100) not null,
    district varchar(100) not null,
    cep varchar(9) not null,
    complement varchar(100),
    numberAddress varchar(20),
    uf char(2) not null,
    city varchar(100) not null,
    primary key(id)
);