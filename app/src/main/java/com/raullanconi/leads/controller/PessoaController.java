/*
 * PessoaController.java
 *
 * Classe Controller responsável por toda a regra de negócio e validação de Pessoa, Utilizando a
 * camada de persistência DAO (Data Access Object) e passando seu devido retorno para a DTO (Data
 * Transfer Object).
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.controller;

import android.content.Context;

import com.raullanconi.leads.dao.PessoaDAO;
import com.raullanconi.leads.dao.Sqlite.DaoFactory;
import com.raullanconi.leads.dto.PessoaDTO;
import com.raullanconi.leads.model.Pessoa;
import com.raullanconi.leads.validator.validations.ObjectValidator;
import com.raullanconi.leads.validator.validations.PessoaValidator;
import com.raullanconi.leads.validator.validators.ErroVerificacao;
import com.raullanconi.leads.validator.validators.Validador;

import java.util.List;

/**
 * Classe PessoaController, representa a camada Controller da arquitetuda MVC.
 *
 * @author Raul Lançoni de Paula
 *
 */
public class PessoaController {

    /**
     * Método create, responsável por fazer as validações de regra de negócio antes de persistir
     * o objeto a fim de fazer sua inserção no Banco de Dados, e verificar se não há nada fora dos
     * padrões definidos de fluxo de dados.
     *
     * @param pPessoa
     * @param pContext
     * @return PessoaDTO - objeto que contem IsOk, Mensagem de status, Objeto ou ListaObjeto;
     */
    public PessoaDTO create(Pessoa pPessoa, Context pContext) {

        ErroVerificacao resultado = Validador.verificar(Validador.consistir(pPessoa, ObjectValidator.validacoes));

        if(resultado.isNotOk())
            return new PessoaDTO(false, resultado.getMensagem());

        PessoaDAO pessoaDAO = DaoFactory.getPessoaDAO(pContext);

        Pessoa pessoa = pessoaDAO.recovery(pPessoa.getId());

        if(pessoa != null)
            return new PessoaDTO(false, "Já existe pessoa cadastrada com esse ID!");

        pessoa = pessoaDAO.create(pPessoa);

        if(pessoa == null)
            return new PessoaDTO(false, "Problemas na gravação de pessoa!");

        return new PessoaDTO(true, "Pessoa cadastrada com sucesso!", pessoa);

    }

    /**
     * Método update, responsável por fazer as validações de regra de negócio antes de persistir
     * o objeto a fim de fazer sua atualização no Banco de Dados, e verificar se não há nada fora
     * dos padrões definidos de fluxo de dados.
     *
     * @param pPessoa
     * @param pContext
     * @return PessoaDTO - objeto que contem IsOk, Mensagem de status, Objeto ou ListaObjeto;
     */
    public PessoaDTO update(Pessoa pPessoa, Context pContext) {

        ErroVerificacao resultado = Validador.verificar(Validador.consistir(pPessoa, ObjectValidator.validacoes));

        if(resultado.isNotOk())
            return new PessoaDTO(false, resultado.getMensagem());

        PessoaDAO pessoaDAO = DaoFactory.getPessoaDAO(pContext);

        Pessoa pessoa = pessoaDAO.update(pPessoa);

        if(pessoa == null)
            return new PessoaDTO(false, "Pessoa não existe no cadastro!");

        return new PessoaDTO(true, "Pessoa atualizado com sucesso!", pessoa);

    }

    /**
     * Método delete, responsável por fazer as validações de regra de negócio antes de persistir
     * o objeto a fim de fazer sua remoção do Banco de Dados, e verificar se não há nada fora dos
     * padrões definidos de fluxo de dados.
     *
     * @param pId
     * @param pContext
     * @return PessoaDTO - objeto que contem IsOk, Mensagem de status, Objeto ou ListaObjeto;
     */
    public PessoaDTO delete(int pId, Context pContext) {

        ErroVerificacao resultado = Validador.verificar(Validador.consistir(pId, PessoaValidator.validacaoId));

        if(resultado.isNotOk())
            return new PessoaDTO(false, resultado.getMensagem());

        PessoaDAO pessoaDAO = DaoFactory.getPessoaDAO(pContext);

        Pessoa pessoa = pessoaDAO.recovery(pId);

        if(pessoa == null)
            return new PessoaDTO(false, "Pessoa não existe no cadastro!");

        if(pessoaDAO.delete(pId))
            return new PessoaDTO(true, "Pessoa removido com sucesso!", pessoa);
        else
            return new PessoaDTO(false, "Pessoa não foi removido!", pessoa);

    }

    /**
     * Método search, responsável por fazer as validações de regra de negócio antes de persistir
     * o objeto a fim de fazer sua busca completa no Banco de Dados, e verificar se não há nada
     * fora dos padrões definidos de fluxo de dados.
     *
     * @param pContext
     * @return PessoaDTO - objeto que contem IsOk, Mensagem de status, Objeto ou ListaObjeto;s
     */
    public PessoaDTO search(Context pContext) {

        PessoaDAO pessoaDAO = DaoFactory.getPessoaDAO(pContext);

        List<Pessoa> listaPessoa = pessoaDAO.search();

        if(listaPessoa == null || listaPessoa.isEmpty())
            return new PessoaDTO(false, "Lista de Pessoas vazia ou nula!");

        return new PessoaDTO(true, "Lista de pessoas recuperada!", listaPessoa);

    }

}