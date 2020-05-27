package com.example.appdoiago;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

        final Button botaoAtivar = findViewById(R.id.btnAtivar);
        final TextView texto = findViewById(R.id.txtSegredo);
        final Button botaoBurro = findViewById(R.id.btnBurro);

        botaoAtivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                texto.setText("Continue clicando no botão para ver o Segredo");
                botaoAtivar.setVisibility(View.GONE);

                texto.setClickable(true);

                texto.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        int i = 0;

                        while (i <= 2) {

                            if(i == 0) {
                                texto.setText("Não tá achando o botão né?");
                                i++;
                            }
                            else if (i == 1) {
                                texto.setText("Você é burro?!");
                                i++;
                            }
                            else if (i == 2) {
                                texto.setText("Olha o botão ali em cima");
                                botaoBurro.setVisibility(View.VISIBLE);
                                i++;
                            }
                        }

                    }
                });
            }
        });
    }
}
