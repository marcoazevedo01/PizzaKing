create database syspizza;

create table funcionario(
    id serial,
    nome varchar(100),
    salario numeric(10,2),
    telefone varchar(30),
    constraint pk_funcionario primary key (id)
);

create table cliente(
    id serial,
    nome varchar(100),
    email varchar(100),
    senha varchar(20),
    telefone varchar(30),
    status Boolean,
    constraint pk_cliente primary key (id)
);

create table produto(
    idProduto serial,
    descricao varchar(100),
    dataValidade date,
    medida numeric(10,2),
    valor numeric(10,2),
    constraint pk_produto primary key (idProduto)
);

create table bebida(
    idBebida serial,
    tipo varchar(100),
    idProduto integer,
    constraint pk_bebida primary key (idBebida),
    constraint fk_bebida_produto foreign key (idProduto)
        references produto (idProduto)
);