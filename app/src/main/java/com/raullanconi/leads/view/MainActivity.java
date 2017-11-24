package com.raullanconi.leads.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.raullanconi.leads.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cadastrarPessoa(View pView) {

        startActivity(new Intent(MainActivity.this, CadastroActivity.class));

    }

    public void listarPessoa(View pView) {

        startActivity(new Intent(MainActivity.this, ListarActivity.class));

    }

}
