/*
 * PessoaAdapter.java
 *
 * Classe PessoaAdapter, responsável por preencher a ListView.
 *
 * © 2017 - Raul Lançoni de Paula - Todos os direitos reservados.
 *
 * Histórico
 * 24/11/2017 - Versão 1.0 - Raul Lançoni de Paula - Criação do arquivo.
 *
 */
package com.raullanconi.leads.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.raullanconi.leads.R;
import com.raullanconi.leads.model.Pessoa;

import java.util.List;

/**
 * Classe PessoaAdapter, representa um adapter de Pessoa.
 *
 * @author Raul Lançoni de Paula
 *
 */
public class PessoaAdapter extends ArrayAdapter<Pessoa> {

    /**
     * Atributo resource, referente ao activity que será manipulado.
     */
    private int resource;
    /**
     * Atributo listaPessoa, referente a lista de Pessoa que será mostrada no activity.
     */
    private List<Pessoa> listaPessoa;

    /**
     * Construtor PessoaAdapter(Context pContext, int pResource, List<Pessoa> pListaPessoa) de
     * PessoaAdapter.
     *
     * @param pContext
     * @param pResource
     * @param pListaPessoa
     */
    public PessoaAdapter(Context pContext, int pResource, List<Pessoa> pListaPessoa) {

        super(pContext, pResource, pListaPessoa);
        this.resource = pResource;
        this.listaPessoa = pListaPessoa;

    }

    /**
     * Método getView, principal responsável no uso do adapter de pessoa, especifica como será
     * preenchido o ListView através do adapter. Utiliza o LayoutInflater para popular a view
     * com os respectivos objetos de listaPessoa, após isso, define individualmente os valores
     * de textField de Pessoa.
     *
     * @param pPosition
     * @param pSource
     * @param pParent
     * @return View - retorna uma view com os devidos atributos que irão ser mostrados na tela.
     */
    @Override
    public View getView(int pPosition, View pSource, ViewGroup pParent) {

        View view = pSource;
        TextView textId, textNome, textTelefone;
        Pessoa pessoa;

        if(view == null) {

            LayoutInflater inflater =
                    (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource, null);

        }

        pessoa = listaPessoa.get(pPosition);

        textId = (TextView) view.findViewById(R.id.textId);
        textId.setText("ID: " + pessoa.getId());

        textNome = (TextView) view.findViewById(R.id.textNome);
        textNome.setText("Nome: " + pessoa.getNome());

        textTelefone = (TextView) view.findViewById(R.id.textTelefone);
        textTelefone.setText("Telefone: " + pessoa.getTelefone());

        return view;

    }

}