create database ecommerce;

use ecommerce;

create table if not exists produtos (

id int auto_increment primary key,
nome VARCHAR(100) not null,
descricao text,
preco DECIMAL(10, 2) not null,
quantidade_estoque int not null default 0,
data_cadastro timestamp default current_timestamp

);


create table if not exists trasacoes(

id int auto_increment primary key,
valor decimal(10, 2) not null,
metodo_pagamento varchar(50) not null,
data_transacao timestamp not null,
status varchar(20) not null

);


create table if not exists email(

id int auto_increment primary key,
destinatario varchar(100) not null,
assunto varchar(200) not null,
mensagem text not null,
data_envio timestamp not null,
status varchar(20) not null


);


insert into produtos (nome, descricao, preco, quantidade_estoque) values
('notebook 1', 'notebook com 128gb de armazenamento', 2000.00, 50),
('notebook 2', 'notebook com 258gb de armazenamento', 2500.00, 100),
('notebook 3', 'notebook com 518gb de armazenamento', 3000.00, 90),
('notebook 4', 'notebook com 1tb de armazenamento', 3500.00, 40),
('notebook 5', 'notebook com 2tb de armazenamento', 4500.00, 45);





