create database supermercado;

use supermercado;

create table filial (
idfilial int primary key auto_increment,
nome varchar(50),
CNPJ varchar(50),
logradouro 	varchar(50),
numero	int,
complemento	varchar(50),
cep	varchar(50),
cidade varchar(50),
UF varchar(10));

create table usuario (
id int primary key auto_increment,
nome varchar(50),
cpf varchar(50),
perfil varchar(50),
login varchar(50),
senha varchar(50),
senha_adm varchar(50),
filial varchar(50),
idfilial int);

create table endereco (
idendereco int primary key auto_increment,
logradouro 	varchar(50),
numero	int,
complemento	varchar(50),
cep	varchar(50),
cidade varchar(50),
UF varchar(10));

create table venda(
idvenda int primary key auto_increment,
nomeproduto varchar(50),
codigoproduto varchar(50),
categoria varchar(50),
qtd int,
preco_unitario double,
preco_total double,
usuario varchar(50),
nomeCLiente varchar(50),
cpfCliente varchar(50),
nomeFilial varchar(50),
tipoPagto varchar(50)
);
    
create table cliente (
idCliente int primary key auto_increment,
nomecli varchar(50),
sexo varchar(50),
CPF varchar(50),
rg varchar(50),
estadoCivil varchar(50),
telefone varchar(50),
dataNascimento varchar(50),
email varchar(50),
logradouro varchar(50),
numero varchar(50),
complemento varchar(50),
cep varchar(50),
cidade varchar(50),
UF varchar(50));

create table produto (
idproduto int primary key auto_increment,
nome varchar(50),
codigoproduto varchar(50),
categoria varchar(50),
qtd int,
preco double,
idfilial int,
foreign key (idfilial) references filial (idfilial));

create table formapagamento(
idpagamento int primary key auto_increment,
credito varchar(50),
debito varchar(50),
dinheiro varchar(50),
alimentacao varchar(50));

create table relatorio(
idrelatorio int primary key auto_increment,
nomeproduto varchar(50),
codigoproduto varchar(50),
categoria varchar(50),
qtd_vendido int,
preco_unitario double,
preco_total double,
data_venda date,
usuario varchar(50),
nomeCLiente varchar(50),
cpfCliente varchar(50),
nomeFilial varchar(50),
forma_pagamento varchar(50));

insert into formapagamento (credito, debito, dinheiro, alimentacao)value("Cartão de Crédito", "Cartão de Débito", "Dinheiro", "Voucher Alimentação");

insert into usuario (nome, cpf, filial, perfil, login, senha, senha_adm) value(
"Rafael Rocha Alves Louzano", "36492912829", "admin", "CDSP", "rlouzano", "123", "123");


insert into endereco (logradouro, numero, complemento, cep, cidade, UF) value(
"rua joao ferreira de abreu", 533, "Ap 33 B", "04445-140", "São Paulo", "SP");


insert into cliente (nomecli, sexo, CPF, rg, estadoCivil, telefone, dataNascimento, email, idendereco) value(
"Rafael Louzano", "Masculino", "36492912829", "443634634", "Casado", "11986232910", "08/04/1988", "rafael.louzanoo@gmail.com", 1);


insert into filial (nome, CNPJ, logradouro, numero, complemento, cep, cidade, UF)value(
"São Paulo", "012335463400001-4", "rua jardins", "43", "ap17 B", "01516-044", "São Paulo", "SP");

insert into produto (nome, codigoproduto, categoria, qtd, preco, idfilial)value( 
"Arroz", "32564123574", "Alimentos", 1, 5.0, 1);

insert into venda (nome, codigoproduto, categoria, qtd, preco, nome_filial)value(
"Arroz", "1543414315", "Alimentos", 3, 3.50, "CDSP");

select r.data_venda, c.nomecli, v.nome, v.codigoproduto, v.categoria, v.qtd, v.preco, v.nome_filial, u.login  from relatorio as r
inner join cliente as c  on r.idCliente like c.idCliente inner join venda as v on r.idvenda like v.idvenda inner join usuario as u  on r.id like u.id ;

select r.data_venda, c.nomecli, v.nome, v.codigoproduto, v.categoria, v.qtd, v.preco, v.nome_filial, u.login, sum(v.qtd), sum(v.preco), avg(v.qtd), avg(v.preco) from relatorio as r
inner join cliente as c  on r.idCliente like c.idCliente inner join venda as v on r.idvenda like v.idvenda inner join usuario as u  on r.id like u.id ;

select p.idproduto, p.nome, p.codigoproduto, p.categoria, p.qtd, p.preco, f.nome from produto as p
inner join filial as f on p.idfilial = f.idfilial  where p.nome like "Arroz" or p.codigoproduto like "0";
