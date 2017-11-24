/*
 * PessoaDTO.java
 *
 * Classe DTO (Data Transfer Object) da Model Pessoa.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.dto;

import com.raullanconi.leads.model.Pessoa;

import java.util.List;

/**
 * Classe PessoaDTO, representa uma Data Transfer Object filha de AbstractDTO e
 * referente a Model Pessoa.
 *
 * @author Raul Lançoni de Paula
 *
 */
public class PessoaDTO extends AbstractDTO<Pessoa> {

    /**
     * Construtor PessoaDTO(boolean pOk, String pMessage)
     * da classe PessoaDTO.
     *
     * @param pOk
     * @param pMessage
     */
    public PessoaDTO(boolean pOk, String pMessage) {

        super(pOk, pMessage);

    }

    /**
     * Construtor PessoaDTO(boolean pOk, String pMessage, Pessoa pPessoa)
     * da classe PessoaDTO.
     *
     * @param pOk
     * @param pMessage
     * @param pPessoa
     */
    public PessoaDTO(boolean pOk, String pMessage, Pessoa pPessoa) {

        super(pOk, pMessage, pPessoa);

    }

    /**
     * Construtor PessoaDTO(boolean pOk, String pMessage, List<Pessoa> pListPessoa)
     * da classe PessoaDTO.
     *
     * @param pOk
     * @param pMessage
     * @param pListPessoa
     */
    public PessoaDTO(boolean pOk, String pMessage, List<Pessoa> pListPessoa) {

        super(pOk, pMessage, pListPessoa);

    }

}