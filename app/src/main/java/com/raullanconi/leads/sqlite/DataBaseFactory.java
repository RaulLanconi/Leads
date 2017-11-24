/*
 * DataBaseFactory.java
 *
 * Classe de conexão com o banco de dados SQLite, responsável pela criação ou atualização do
 * banco de dados.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Classe DataBaseFactory responsável pelo Banco de Dados SQLite.
 *
 * @author Raul Lançoni de Paula
 */
public class DataBaseFactory extends SQLiteOpenHelper {

    /**
     * Construtor DataBaseFactory(Context pContext), inicia a base de dados com o contexto atual,
     * nome do banco de dados, e a versão do banco.
     *
     * @param pContext
     */
    public DataBaseFactory(Context pContext) {

        super(pContext, DataBase.NOME_BANCO, null, DataBase.VERSAO);

    }

    /**
     * Método onCreate, responsável por criar a base de dados quando o aplicativo é íniciado.
     *
     * @param pSQLiteDataBase
     */
    @Override
    public void onCreate(SQLiteDatabase pSQLiteDataBase) {

        String cmdSql = "CREATE TABLE " + DataBase.TABELA_PESSOA + "("
                + DataBase.ID_PESSOA + " integer primary key autoincrement,"
                + DataBase.NOME_PESSOA + " text,"
                + DataBase.TELEFONE_PESSOA + " text"
                + ")";

        pSQLiteDataBase.execSQL(cmdSql);

    }

    /**
     * Método onUpgrade, responsável por fazer a atualização do banco caso a versão mude.
     *
     * @param pSQLiteDataBase
     * @param pOldVersion
     * @param pNewVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase pSQLiteDataBase, int pOldVersion, int pNewVersion) {

        pSQLiteDataBase.execSQL("DROP TABLE IF EXISTS " + DataBase.TABELA_PESSOA);
        onCreate(pSQLiteDataBase);

    }

}