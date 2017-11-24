/*
 * PessoaDaoSqlite.java
 *
 * Classe DaoSqlite referente a Pessoa, responsável por fazer operações
 * CRUDSC em qualquer objeto Pessoa na base de dados (persistência).
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.dao.Sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.raullanconi.leads.dao.PessoaDAO;
import com.raullanconi.leads.model.Pessoa;
import com.raullanconi.leads.sqlite.DataBase;
import com.raullanconi.leads.sqlite.DataBaseFactory;
import com.raullanconi.leads.util.UtilErrorInputOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe PessoaDaoSqlite, responsável por fazer a persistência a Pessoa.
 *
 * @author Raul Lançoni de Paula
 *
 */
public class PessoaDaoSqlite extends AbstractDaoSqlite<Pessoa> implements PessoaDAO {

    /**
     * Atributo myConnection, responsável por armazenar a conexão com o Banco de Dados.
     */
    private SQLiteDatabase myConnection;
    /**
     * Atributo myDataBase, responsável por referenciar as tabelas do sistema, nome do banco e
     * versão.
     */
    private DataBaseFactory myDataBase;

    /**
     * Construtor PessoaDaoSqlite(Context pContext) responsável por obter a conexão com o banco.
     *
     * @param pContext
     */
    public PessoaDaoSqlite(Context pContext) {

        myDataBase = new DataBaseFactory(pContext);

    }

    /**
     * Método create, referente a fazer uma inserção (insert) de um Pessoa
     * no banco de dados.
     *
     * @param pPessoa
     * @return Pessoa - objeto Model Pessoa
     */
    @Override
    public Pessoa create(Pessoa pPessoa) {

        Pessoa pessoa = null;

        try {

            myConnection = myDataBase.getWritableDatabase();
            ContentValues cv = new ContentValues();
            long id;

            cv.put(DataBase.NOME_PESSOA, pPessoa.getNome());
            cv.put(DataBase.TELEFONE_PESSOA, pPessoa.getTelefone());

            if((id = myConnection.insertOrThrow(DataBase.TABELA_PESSOA, null, cv))
                    != -1) {
                pessoa = pPessoa;
                pessoa.setId((int)id);
            }

            myConnection.close();

        }
        catch(SQLException pException) {
            UtilErrorInputOutput.mostrarErro(pException, "Erro no método de criação " +
                    "de objeto Pessoa!");
        }

        return pessoa;

    }

    /**
     * Método recovery, responsável por fazer uma recuperação (select) de um
     * determinado Pessoa por ID no banco de dados.
     *
     * @param pId
     * @return Pessoa - objeto Model Pessoa
     */
    @Override
    public Pessoa recovery(int pId) {

        Pessoa pessoa = null;

        try {

            myConnection = myDataBase.getReadableDatabase();
            ContentValues cv = new ContentValues();
            String[] campos = { DataBase.ID_PESSOA, DataBase.NOME_PESSOA, DataBase.TELEFONE_PESSOA};
            String where = DataBase.ID_PESSOA + " = " + pId;
            Cursor cursor;

            cursor = myConnection.query(DataBase.TABELA_PESSOA, campos, where, null,
                    null, null, null, null);

            pessoa = executeRecovery(pessoa, cursor);

            myConnection.close();

        }
        catch(SQLException pException) {
            UtilErrorInputOutput.mostrarErro(pException, "Erro no método de recuperação "
                    + "do objeto Pessoa!");
        }

        return pessoa;

    }

    /**
     * Método update, responsável por fazer uma atualização (update) de um
     * determinado Pessoa por ID no banco de dados.
     *
     * @param pPessoa
     * @return Pessoa - objeto Model Pessoa
     */
    @Override
    public Pessoa update(Pessoa pPessoa) {

        Pessoa pessoa = null;

        try {

            myConnection = myDataBase.getWritableDatabase();
            ContentValues cv = new ContentValues();
            String where = DataBase.ID_PESSOA + " = " + pPessoa.getId();

            cv.put(DataBase.NOME_PESSOA, pPessoa.getNome());
            cv.put(DataBase.TELEFONE_PESSOA, pPessoa.getTelefone());

            if(myConnection.update(DataBase.TABELA_PESSOA, cv, where, null) != -1)
                pessoa = pPessoa;

            myConnection.close();

        }
        catch(SQLException pException) {
            UtilErrorInputOutput.mostrarErro(pException, "Erro no método de atualização "
                    + "do objeto Pessoa!");
        }

        return pessoa;

    }

    /**
     * Método delete, responsável por fazer uma exclusão (delete) de um
     * determinado Pessoa por ID no banco de dados.
     *
     * @param pId
     * @return boolean - true or false of transation
     */
    @Override
    public boolean delete(int pId) {

        try {

            myConnection = myDataBase.getReadableDatabase();
            String where = DataBase.ID_PESSOA + " = " + pId;

            return (myConnection.delete(DataBase.TABELA_PESSOA, where, null) == 1);

        }
        catch(SQLException pException) {
            UtilErrorInputOutput.mostrarErro(pException, "Erro no método de exclusão "
                    + "do objeto Pessoa!");
        }

        return false;

    }

    /**
     * Método search, responsável por retornar todos os Pessoas existentes no
     * banco de dados.
     *
     * @return List<Pessoa> - lista de Model Pessoaes
     */
    @Override
    public List<Pessoa> search() {

        List<Pessoa> listaPessoa = new ArrayList<>();

        try {

            myConnection = myDataBase.getReadableDatabase();
            ContentValues cv = new ContentValues();
            String[] campos = { DataBase.ID_PESSOA, DataBase.NOME_PESSOA, DataBase.TELEFONE_PESSOA};
            Cursor cursor;

            cursor = myConnection.query(DataBase.TABELA_PESSOA, campos, null,
                    null, null, null, null);

            listaPessoa = executeSearch(listaPessoa, cursor);

            myConnection.close();

        }
        catch(SQLException pException) {
            UtilErrorInputOutput.mostrarErro(pException, "Erro no método de recuperação "
                    + "da lista de objeto Pessoa!");
        }

        return listaPessoa;

    }

    /**
     * Método loadObject, se refere a uma forma abstrata do método loadObject de
     * cada Classe *DaoSqlite, onde obriga a cada Classe *DaoSqlite a implementá-lo
     * obrigatóriamente.
     *
     * @param pCursor
     * @return <T> Object (genérico, qualquer Classe Model)
     */
    @Override
    public Pessoa loadObject(Cursor pCursor) {

        Pessoa pessoa = new Pessoa();

        pessoa.setId(pCursor.getInt(pCursor.getColumnIndexOrThrow(DataBase.ID_PESSOA)));
        pessoa.setNome(pCursor.getString(pCursor.getColumnIndexOrThrow(DataBase.NOME_PESSOA)));
        pessoa.setTelefone(pCursor.getLong(pCursor.getColumnIndexOrThrow(DataBase.TELEFONE_PESSOA)));

        return pessoa;

    }

}