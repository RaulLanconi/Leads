/*
 * AbstractDaoJdbc.java
 *
 * Classe abstract que representa uma extensão obrigatória de qualquer classe *DaoSqlite,
 * onde os métodos recovery, search são genéricos, e podem ser utilizados sem repetir código.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.dao.Sqlite;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

/**
 * Classe AbstractDaoSqlite, representa uma extensão obrigatória de qualquer classe *DaoSqlite.
 *
 * @author Raul Lançoni de Paula
 *
 */
public abstract class AbstractDaoSqlite<T> {

    /**
     * Método executeRecovery, representa a forma genérica de se executar parte de uma execução
     * recovery, dentro do SQLite, especificamente a parte onde se executa a query e atribui ela
     * ao Cursor e para o objeto, bem como fechar o Cursor e o SQLiteDatabase, mais precisamente,
     * o método retorna um objeto <T> genérico carregado com a execução SQL.
     *
     * @param pObjeto
     * @param pCursor
     * @return <T> pObjeto
     * @throws SQLException
     */
    public T executeRecovery(T pObjeto, Cursor pCursor) throws SQLException {

        if(pCursor.moveToFirst())
            pObjeto = loadObject(pCursor);

        pCursor.close();

        return pObjeto;

    }

    /**
     * Método executeSearch, representa a forma genérica de se executar parte de uma execução
     * search, dentro do Sqlite, especificamente a parte onde se executa a query e atribui ela
     * ao Cursor e para o objeto, bem como fechar o Cursor e o SQLiteDatabase, mais precisamente,
     * o método retorna um objeto List<T> genérico carregado com a execução SQL.
     *
     * @param pListaObjeto
     * @param pCursor
     * @return List<T> pListaObjeto
     * @throws SQLException
     */
    public List<T> executeSearch(List<T> pListaObjeto, Cursor pCursor) throws SQLException {

        while(pCursor.moveToNext())
            pListaObjeto.add(loadObject(pCursor));

        pCursor.close();

        return pListaObjeto;

    }

    /**
     * Método loadObject, se refere a uma forma abstrata do método loadObject de
     * cada Classe *DaoSqlite, onde obriga a cada Classe *DaoSqlite a implementá-lo
     * obrigatóriamente.
     *
     * @param pCursor
     * @return <T> Object (genérico, qualquer Classe Model)
     */
    public abstract T loadObject(Cursor pCursor);

}