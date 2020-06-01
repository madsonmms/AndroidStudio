package com.example.jokenpo_edicaobacteria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends Activity {

    //criando as imagens no main
    ImageView versus;
    ImageView jogador1;
    ImageView jogador2;

    //criando os botões
    ImageButton botaoPedra;
    ImageButton botaoPapel;
    ImageButton botaoTesoura;

    //criando animações
    Animation some;
    Animation aparece;

    //criando variáveis de comparação
    int jogada1 = 0;
    int jogada2 = 0;

    MediaPlayer media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciando e startando música de fundo
        media = MediaPlayer.create(MainActivity.this, R.raw.bacteria_fdp);
        media.start();

        //instanciando objetos
        versus = findViewById(R.id.imgVersus);
        jogador1 = findViewById(R.id.imgJogador1);
        jogador2 = findViewById(R.id.imgJogador2);

        botaoPedra = findViewById(R.id.imgBtnPedra);
        botaoPapel = findViewById(R.id.imgBtnPapel);
        botaoTesoura = findViewById(R.id.imgBtnTesoura);

        //setando animações
        some = new AlphaAnimation(1,0);
        aparece = new AlphaAnimation(0,1);

        //setando duração das animações
        some.setDuration(250);
        aparece.setDuration(100);

        some.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                //faz a animação de aparecer toda vez que o sumir terminar
                jogador2.setVisibility(View.INVISIBLE);
                jogador2.startAnimation(aparece);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        aparece.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //sorteia o adversário e verifica quem ganhou antes da imagem sumir
                sorteiaJogadorAdversario();
                verificaJogada();
                jogador2.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                jogador2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void clickouBotao(View view){

        //inverte a imagem do jogador1 (usuário)
        jogador1.setScaleX(-1);

        //define imagens e o número usado para comparação
        switch(view.getId()){
            case(R.id.imgBtnPedra):
                jogador1.setImageResource(R.drawable.pedra);
                jogada1 = 1;
                break;

            case(R.id.imgBtnPapel):
                jogador1.setImageResource(R.drawable.papel);
                jogada1 = 2;
                break;

            case(R.id.imgBtnTesoura):
                jogador1.setImageResource(R.drawable.tesoura);
                jogada1 = 3;
                break;
        }

        //faz a imagem do cubo aparecer e sumir após o botão ser clicado
        jogador2.setImageResource(R.drawable.interrogacao);
        jogador2.startAnimation(some);
    }

    //função de geração de jogada aleatória
    public void sorteiaJogadorAdversario(){
        Random verificador = new Random();
        int numVerificador = verificador.nextInt(3);

        switch(numVerificador){
            case 0:
                jogador2.setImageResource(R.drawable.pedra);
                jogada2 = 1;
                break;
            case 1:
                jogador2.setImageResource(R.drawable.papel);
                jogada2 = 2;
                break;
            case 2:
                jogador2.setImageResource(R.drawable.tesoura);
                jogada2 = 3;
                break;
        }
    }

    //função que compara a jogada
    public void verificaJogada(){

        if(jogada1==jogada2) {
            Toast.makeText(this, "Empate! CARALHO ACABA LOGO QUARENTENA!", Toast.LENGTH_SHORT).show();
        }
        else if ((jogada1 == 1 && jogada2 == 3) ||
                (jogada1 == 2 && jogada2 == 1) ||
                (jogada1 == 3 && jogada2 == 2))
        {
            Toast.makeText(this, "Ganhei! Bactéria FILHADAPUTA!", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Perdeu! Micróbio do CARALHO!", Toast.LENGTH_SHORT).show();
        }

    }

    //funções para parar a música ao pausar ou destruir a aplicação
    @Override
    protected void onPause() {
        super.onPause();
        media.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        media.stop();
    }
}
