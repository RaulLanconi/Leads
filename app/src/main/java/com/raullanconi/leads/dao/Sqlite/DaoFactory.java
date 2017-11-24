/*
 * DaoFactory.java
 *
 * Classe Factory refrente a instanciação de DAO (Data Access Object).
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.dao.Sqlite;

import android.content.Context;

import com.raullanconi.leads.dao.PessoaDAO;

/**
 * Classe DaoFactory de DAO's no sistema.
 *
 * @author Raul Lançoni de Paula
 *
 */
public class DaoFactory {

    /**
     * Método getPessoaDao, responsável por retornar uma nova instância de *DaoSqlite.
     *
     * @return new PessoaDaoSqlite - novo DAO
     */
    public static PessoaDAO getPessoaDAO(Context pContext) {

        return new PessoaDaoSqlite(pContext);

    }

}