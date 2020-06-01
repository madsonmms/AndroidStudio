package com.example.appaeroporto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {

    //cria as variáveis com os elementos que serão usados (precisa de import)
    ImageView imagem;
    TextView texto;

    //cria as variáveis das animações (precisa de import)
    Animation aparece;
    Animation some;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pega os elementos que serão usados pelo ID
        imagem = findViewById(R.id.imgSeta);
        texto = findViewById(R.id.txtTitulo);

        //define a animação que será utilizada (precisa de import)
        //AlphaAnimation - usada para fade in ou fade out controlando transparência (valor inicial, valor final)
        aparece = new AlphaAnimation(0,1);
        some = new AlphaAnimation(1,0);

        //propriedade para informar a duração da animação em milisegundos
        some.setDuration(500);
        aparece.setDuration(500);

        texto.setText("Toque para Continuar");
        imagem.setVisibility(View.INVISIBLE); //setando a imagem para que fique invisível quando o app abrir


        //informa as ações a serem feitas ao começar, terminar ou repetir a animação
        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //imagem.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imagem.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        //Fim dos listeners
    }

    public void clickNaTela(View view) {

        //ao clicar na tela faz a seta aparecer com animação
        imagem.startAnimation(aparece);
        imagem.setVisibility(View.VISIBLE);

        if(Math.random() < 0.5){ //random gera um número de 0.0 à 1.0
            texto.setText("Siga para a direita");
            imagem.setScaleX(-1); //usado para inverter a imagem
        }
        else {
            texto.setText("Siga para a esquerda");
            imagem.setScaleX(1);
        }

        //inicia um timer, usado para definir um delay para a animação sumir após dois segundos
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                texto.setText("Toque para Continuar");
                imagem.startAnimation(some);
            }
        },2000);

    }

}
