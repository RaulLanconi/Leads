package com.raullanconi.leads.view;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.raullanconi.leads.R;
import com.raullanconi.leads.controller.PessoaController;
import com.raullanconi.leads.dto.PessoaDTO;
import com.raullanconi.leads.model.Pessoa;

public class AtualizarActivity extends Activity {

    private PessoaDTO pessoaDTO;
    private PessoaController pessoaController;
    private Pessoa pessoa;
    private TextView textIdUpdate;
    private EditText editNomeUpdate;
    private EditText editTelefoneUpdate;
    private Button btnUpdate;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atualizar);

        pessoaController = new PessoaController();
        pessoa = new Pessoa();

        Intent intent = getIntent();
        pessoa = (Pessoa) intent.getSerializableExtra("pessoa");

        textIdUpdate = (TextView) findViewById(R.id.textIdUpdate);
        editNomeUpdate = (EditText) findViewById(R.id.editNomeUpdate);
        editTelefoneUpdate = (EditText) findViewById(R.id.editTelefoneUpdate);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        textIdUpdate.setText("ID: " + pessoa.getId());
        editNomeUpdate.setText(pessoa.getNome());
        editTelefoneUpdate.setText(pessoa.getTelefone());

        btnUpdate.setOnClickListener(new AdapterView.OnClickListener() {

            @Override
            public void onClick(View pView) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(AtualizarActivity.this);

                alerta.setTitle("Atualizar Pessoa?")
                        .setCancelable(true)
                        .setMessage(textIdUpdate.getText().toString() + "\nNome: " + editNomeUpdate.getText().toString() + "\nTelefone: " + editTelefoneUpdate.getText().toString() + "\n")
                        .setNegativeButton("NÃO", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }

                        })
                        .setPositiveButton("SIM", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                if(editNomeUpdate.getText().toString().isEmpty() || editTelefoneUpdate.getText().toString().isEmpty()) {
                                    Toast.makeText(AtualizarActivity.this, "Nome e Telefone não podem ser vazios!", Toast.LENGTH_LONG).show();
                                    return;
                                }

                                if(editNomeUpdate.getText().toString().length() > 80) {
                                    Toast.makeText(AtualizarActivity.this, "Nome não pode ser maior que 80 caracteres!", Toast.LENGTH_LONG).show();
                                    return;
                                }
                                else if(editTelefoneUpdate.getText().toString().length() > 11) {
                                    Toast.makeText(AtualizarActivity.this, "Telefone não pode ser maior que 11 caracteres!", Toast.LENGTH_LONG).show();
                                    return;
                                }


                                pessoa.setNome(editNomeUpdate.getText().toString());
                                pessoa.setTelefone(editTelefoneUpdate.getText().toString());

                                pessoaDTO = pessoaController.update(pessoa, AtualizarActivity.this);

                                if(pessoaDTO.isOk()) {
                                    Toast.makeText(AtualizarActivity.this, pessoaDTO.getMessage(), Toast.LENGTH_LONG).show();
                                }
                                else
                                    Toast.makeText(AtualizarActivity.this, pessoaDTO.getMessage(), Toast.LENGTH_LONG).show();

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
