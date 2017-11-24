/*
 * Pessoa.java
 *
 * Classe model que representa uma Pessoa no sistema.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.model;

import com.raullanconi.leads.validator.validations.PessoaValidator;
import com.raullanconi.leads.validator.validators.Validador;

import java.io.Serializable;

/**
 * Classe Pessoa, representa uma pessoa no sistema.
 *
 * @author Raul Lançoni de Paula
 *
 */
public class Pessoa implements Serializable {

    /**
     * Atributo String id, especifica o ID e a primary key da tabela pessoa.
     */
    private int id;
    /**
     * Atributo String nome, referente ao nome de Pessoa no sistema, atributo da tabela Pessoa.
     */
    private String nome;
    /**
     * Atributo long telefone, referente ao telefone de Pessoa no sistema, atributo da tabela
     * Pessoa.
     */
    private long telefone;

    /**
     * Construtor padrão da Classe Pessoa.
     */
    public Pessoa() {

        super();

    }

    /**
     * Construtor Pessoa(int pId, String pNome, long pTelefone) da Classe Pessoa.
     *
     * @param pId
     * @param pNome
     * @param pTelefone
     */
    public Pessoa(int pId, String pNome, long pTelefone) {

        super();
        setId(pId);
        setNome(pNome);
        setTelefone(pTelefone);

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param pId the id to set
     */
    public void setId(int pId) {
        Validador.validar(pId, PessoaValidator.validacaoId);
        this.id = pId;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }
    /**
     * @param pNome the nome to set
     */
    public void setNome(String pNome) {
        Validador.validar(pNome, PessoaValidator.validacaoNome);
        this.nome = pNome;
    }

    /**
     * @return the telefone
     */
    public long getTelefone() {
        return telefone;
    }
    /**
     * @param pTelefone the telefone to set
     */
    public void setTelefone(long pTelefone) {
        Validador.validar(pTelefone, PessoaValidator.validacaoTelefone);
        this.telefone = pTelefone;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Teste [id=");
        builder.append(getId());
        builder.append(", nome=");
        builder.append(getNome());
        builder.append(", telefone=");
        builder.append(getTelefone());
        builder.append("]");
        return builder.toString();
    }

    /* Método hashCode() da classe Pessoa.
     *
	 * @see java.lang.Object#hashCode()
	 */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getId();
        return result;
    }

    /* Método equals(Object obj) da classe Pessoa.
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pessoa other = (Pessoa) obj;
        if (getId() != other.getId())
            return false;
        return true;
    }

}