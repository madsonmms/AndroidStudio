package com.example.app01_contapessoas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int numeroAzul = 0;
    int numeroVermelho = 0;
    int numeroCores = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView campoTexto = (TextView) findViewById(R.id.txtCores);

        final Button botaoAzul = (Button) findViewById(R.id.btnAzul);
        final Button botaoVermelho = (Button) findViewById(R.id.btnVermelho);
        final Button botaoReset = (Button) findViewById(R.id.btnReset);

        botaoAzul.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroAzul++;
                numeroCores++;

                String mensagem = Integer.toString(numeroCores);
                campoTexto.setText("Total: " + mensagem + " cores");
                botaoAzul.setText("Cliques no Azul: " + Integer.toString(numeroAzul));
            }
        });

        botaoVermelho.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroVermelho++;
                numeroCores++;

                String mensagem = Integer.toString(numeroCores);
                campoTexto.setText("Total: " + mensagem + " cores");
                botaoVermelho.setText("Cliques no Vermelho: " + Integer.toString(numeroVermelho));
            }
        });

        botaoReset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                numeroAzul= 0;
                numeroVermelho = 0;
                numeroCores = 0;

                botaoAzul.setText(Integer.toString(numeroAzul));
                botaoVermelho.setText(Integer.toString(numeroVermelho));
                campoTexto.setText("Cores: 0");
            }
        });
    }
}
