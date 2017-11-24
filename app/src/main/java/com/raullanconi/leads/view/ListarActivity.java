package com.raullanconi.leads.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.raullanconi.leads.R;
import com.raullanconi.leads.adapters.PessoaAdapter;
import com.raullanconi.leads.controller.PessoaController;
import com.raullanconi.leads.dto.PessoaDTO;
import com.raullanconi.leads.model.Pessoa;

import java.util.List;

public class ListarActivity extends Activity {

    PessoaController pessoaController;
    PessoaDTO pessoaDTO;
    private ListView listViewPessoa;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        pessoaController = new PessoaController();

        pessoaDTO = pessoaController.search(this);

        if(pessoaDTO.isOk()) {

            Toast.makeText(ListarActivity.this, pessoaDTO.getMessage(), Toast.LENGTH_SHORT).show();
            List<Pessoa> listaPessoa = pessoaDTO.getListObject();
            listViewPessoa = (ListView) findViewById(R.id.listaPessoa);
            listViewPessoa.setAdapter(new PessoaAdapter(this, R.layout.item_pessoa, listaPessoa));

            listViewPessoa.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(
                        AdapterView<?> pAdapterView, View pView, int pPosition, long pId) {

                    AlertDialog.Builder alerta =
                            new AlertDialog.Builder(ListarActivity.this);

                    alerta.setTitle("GOSTARIA DE:")
                            .setCancelable(true)
                            .setNegativeButton("APAGAR", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    AlertDialog.Builder alerta =
                                            new AlertDialog.Builder(ListarActivity.this);

                                    alerta.setTitle("Deseja realmente apagar essa Pessoa?")
                                            .setCancelable(true)
                                            .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {

                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                }

                                            })

                                            .setPositiveButton("SIM", new DialogInterface.OnClickListener() {

                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {

                                                    pessoaDTO = pessoaController.delete((listaPessoa.get(pPosition)).getId(), ListarActivity.this);
                                                    Toast.makeText(ListarActivity.this, pessoaDTO.getMessage(), Toast.LENGTH_SHORT).show();
                                                    finish();

                                                }

                                            });

                                    AlertDialog alertDialog = alerta.create();
                                    alertDialog.show();

                                }

                            })
                            .setPositiveButton("ATUALIZAR", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    Intent update = new Intent(ListarActivity.this, AtualizarActivity.class);
                                    update.putExtra("pessoa", listaPessoa.get(pPosition));
                                    startActivity(update);
                                    finish();

                                }

                            })
                            .setNeutralButton("VOLTAR", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }

                            });

                    AlertDialog alertDialog = alerta.create();
                    alertDialog.show();

                }

            });

        }
        else
            Toast.makeText(ListarActivity.this, pessoaDTO.getMessage(), Toast.LENGTH_SHORT).show();

        btnVoltar.setOnClickListener(new AdapterView.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }

        });

    }

}