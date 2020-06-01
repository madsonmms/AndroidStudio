package com.example.meumeanico;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("Meu App", "Bem Vindo!");

        Button botao = findViewById(R.id.meuBotao);
        final TextView texto = findViewById(R.id.meuTexto);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("Hello World!");
            }
        });
    }
}
