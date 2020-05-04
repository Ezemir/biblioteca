# Biblioteca
Aplicação Servlet Java 
Sistema de Cadastro de Livros

Requisitos para funcionamento;

Java 8
Tomcat 8
Postgres 9.6

SCRIPT PARA CRIAÇÃO DA TABELA
CREATE TABLE livro
(
  id serial NOT NULL DEFAULT,
  titulo character varying(255) NOT NULL,
  autor character varying(255) NOT NULL,
  resumo character varying(1000),
  ano character varying(10),
  CONSTRAINT livro_pkey PRIMARY KEY (id)
)
