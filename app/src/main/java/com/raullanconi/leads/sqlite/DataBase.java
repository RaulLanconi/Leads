/*
 * DataBase.java
 *
 * Classe responsável por especificar o nome do banco de dados, versão do banco de dados, tabelas
 * e atributos respectivos.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.sqlite;

/**
 * Classe DataBase especifica o nome do banco de dados, versão do banco de dados, tabelas
 * e atributos respectivos.
 *
 * @author Raul Lançoni de Paula
 */
public abstract class DataBase {

    /**
     * Atributo static, final, String NOME_BANCO, referente ao nome do banco de dados usado pela
     * aplicação.
     */
    public static final String  NOME_BANCO      = "leads.db";
    /**
     * Atributo static, final, String VERSAO, referente a versão atual da base de dados.
     */
    public static final int     VERSAO          = 1;

    /**
     * Atributo static, final, String TABELA_PESSOA, especifica a tabela PESSOA no sistema,
     * referente à model Pessoa.
     */
    public static final String  TABELA_PESSOA   = "pessoa";
    /**
     * Atributo static, final, String ID_PESSOA, especifica o ID e a primary key da tabela pessoa.
     */
    public static final String  ID_PESSOA       = "_id";
    /**
     * Atributo static, final, String NOME_PESSOA, referente ao nome de Pessoa no sistema, atributo
     * da tabela Pessoa.
     */
    public static final String  NOME_PESSOA       = "nome";
    /**
     * Atributo static, final, String TELEFONE_PESSOA, referente ao telefone de Pessoa no sistema,
     * atributo da tabela Pessoa.
     */
    public static final String TELEFONE_PESSOA = "telefone";

}