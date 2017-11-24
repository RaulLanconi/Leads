/*
 * PessoaDAO.java
 *
 * Classe model que representa uma interface DAO (Data Access Object) de Pessoa.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.dao;

import java.util.List;

import com.raullanconi.leads.model.Pessoa;

/**
 * Classe PessoaDAO, representa uma interface DAO a ser implementada.
 *
 * @author Raul Lançoni de Paula
 *
 */
public interface PessoaDAO {

    /**
     * Método create, referente a fazer uma inserção (insert) de um Pessoa
     * no banco de dados.
     *
     * @param pPessoa
     * @return Pessoa - objeto Model Pessoa
     */
    public abstract Pessoa create(Pessoa pPessoa);

    /**
     * Método recovery, responsável por fazer uma recuperação (select) de um
     * determinado Pessoa por ID no banco de dados.
     *
     * @param pId
     * @return Pessoa - objeto Model Pessoa
     */
    public abstract Pessoa recovery(int pId);

    /**
     * Método update, responsável por fazer uma atualização (update) de um
     * determinado Pessoa por ID no banco de dados.
     *
     * @param pPessoa
     * @return Pessoa - objeto Model Pessoa
     */
    public abstract Pessoa update(Pessoa pPessoa);

    /**
     * Método delete, responsável por fazer uma exclusão (delete) de um
     * determinado Pessoa por ID no banco de dados.
     *
     * @param pId
     * @return boolean - true or false of transation
     */
    public abstract boolean delete(int pId);

    /**
     * Método search, responsável por retornar todos os Pessoas existentes no
     * banco de dados.
     *
     * @return List<Pessoa> - lista de Model Pessoaes
     */
    public abstract List<Pessoa> search();

}