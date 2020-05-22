Servidor: GlassFish Server

Conexao MySQL: com.mysql.cj.jdbc.Driver
Login e senha banco de dados
login = "root"
senha = "";


create database supermercado;
create table venda(
	idvenda int primary key auto_increment,
	nome varchar(50),
	codigoproduto varchar(50),
	qtd int,
    preco double
);



create table administrador(
	id_adm int primary key auto_increment,
	nome varchar(50),
	email varchar(50)
);
create table usuario (
	id int primary key auto_increment,
	nome varchar(50),
    cpf varchar(50),
    cargo varchar(50),
	login varchar(50),
	senha varchar(50),
    senha_adm varchar(50)
);
use supermercado;
create table cadastroCliente(
	id_pessoa int primary key auto_increment,
	nome varchar(50),
	telefone varchar(50),
	cpf varchar(50), 
	rg varchar(50),
	email varchar(50),
	idUsuario int,
	foreign key (idUsuario) references usuario(id)
);
use supermercado;
create table enderecoCliente(
	id_endereco int primary key auto_increment,
	endereco varchar(50),
	numero int,
	uf varchar(50),
	cidade varchar(50),
	cep varchar(50),
	complemento varchar(50),
    idPessoa int,
    foreign key (idPessoa) references cadastroCliente(id_pessoa)
);

use supermercado;
create table produto(
	idproduto int primary key auto_increment,
	nome varchar(50),
	codigoproduto varchar(50),
	qtd int,
    preco double
);

create table relatorio_analitico(
	id_relatorio_analitico int primary key auto_increment,
	qtd_venda int,
	qtd_media int,
	valor_total double,
	media_valor double,
	data_venda date,
    idprod int,
	foreign key (idprod) references produto (idproduto)
);
use supermercado;
create table relatorio_sintetico(
	id_relatorio_sintetico int primary key auto_increment,
	qtd_venda int,
	qtd_media int,
	valor_total double,
	media_valor double,
	data_venda date,
    idprod int,
	foreign key (idprod) references produto (idproduto)
);	