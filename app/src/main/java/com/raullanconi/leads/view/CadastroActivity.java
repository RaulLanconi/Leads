package com.raullanconi.leads.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.raullanconi.leads.R;
import com.raullanconi.leads.controller.PessoaController;
import com.raullanconi.leads.dto.PessoaDTO;
import com.raullanconi.leads.model.Pessoa;

public class CadastroActivity extends Activity {

    private PessoaDTO pessoaDTO;
    private PessoaController pessoaController;
    private Pessoa pessoa;
    private EditText editNome;
    private EditText editTelefone;
    private Button btnSalvar;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        pessoaController = new PessoaController();
        pessoa = new Pessoa();

        editNome = (EditText) findViewById(R.id.editNome);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
        btnSalvar = (Button) findViewById(R.id.btnCreate);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        btnSalvar.setOnClickListener(new AdapterView.OnClickListener() {

            @Override
            public void onClick(View pView) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(CadastroActivity.this);

                alerta.setTitle("Inserir nova Pessoa?")
                        .setCancelable(true)
                        .setMessage("Nome: " + editNome.getText().toString() + "\nTelefone: " + editTelefone.getText().toString() + "\n")
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }

                        })
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if(editNome.getText().toString().isEmpty() || editTelefone.getText().toString().isEmpty()) {
                                    Toast.makeText(CadastroActivity.this, "Nome e Telefone não podem ser vazios!", Toast.LENGTH_LONG).show();
                                    return;
                                }

                                if(editNome.getText().toString().length() > 80) {
                                    Toast.makeText(CadastroActivity.this, "Nome não pode ser maior que 80 caracteres!", Toast.LENGTH_LONG).show();
                                    return;
                                }
                                else if(editTelefone.getText().toString().length() > 11) {
                                    Toast.makeText(CadastroActivity.this, "Telefone não pode ser maior que 11 caracteres!", Toast.LENGTH_LONG).show();
                                    return;
                                }

                                pessoa.setNome(editNome.getText().toString());
                                pessoa.setTelefone(editTelefone.getText().toString());

                                pessoaDTO = pessoaController.create(pessoa, CadastroActivity.this);

                                if(pessoaDTO.isOk()) {
                                    pessoa = pessoaDTO.getObject();
                                    Toast.makeText(CadastroActivity.this, pessoaDTO.getMessage(), Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(CadastroActivity.this, pessoaDTO.getMessage(), Toast.LENGTH_LONG).show();

                                finish();

                            }

                        })
                        .setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }

                        });

                AlertDialog alertDialog = alerta.create();
                alertDialog.show();

            }

        });

        btnVoltar.setOnClickListener(new AdapterView.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }

        });

    }

}
