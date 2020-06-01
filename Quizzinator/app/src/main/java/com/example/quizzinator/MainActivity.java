package com.example.quizzinator;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    //declaração de variáveis
    RadioGroup radOpcoes;
    TextView txtPergunta;

    RadioButton radOpcaoA;
    RadioButton radOpcaoB;
    RadioButton radOpcaoC;

    Button btnOk;

    //declaração de arrays para armazenar perguntas e opções
    String perguntas[] = {"Primeira pergunta?",
            "Segunda pergunta?",
            "Terceira pergunta?",
            "Quarta pergunta?",
            "Quinta pergunta"};

    //Armazena o texto de cada opção para cada pergunta
    String OpcaoA[] = {"Resposta A primeira pergunta",
            "Resposta A segunda pergunta",
            "Resposta A terceira pergunta",
            "Resposta A quarta pergunta",
            "Resposta A quinta pergunta"};

    String OpcaoB[] = {"Resposta B primeira pergunta",
            "Resposta B segunda pergunta",
            "Resposta B terceira pergunta",
            "Resposta B quarta pergunta",
            "Resposta B quinta pergunta"};

    String OpcaoC[] = {"Resposta C primeira pergunta",
            "Resposta C segunda pergunta",
            "Resposta C terceira pergunta",
            "Resposta C quarta pergunta",
            "Resposta C quinta pergunta"};

    //Array que armazena as respostas do usuário, tem o mesmo tamanho da array de perguntas
    int[] listaRespostas = new int[perguntas.length];

    //array com gabarito
    int listaGabarito[] = {1, 2, 3, 1, 2};

    //variável para guardar número de respostas corretas
    int respostasCorretas = 0;

    //variável para guardar o número da pergunta atual
    int numeroPergunta = 0;

    @SuppressLint("SourceLockedOrientationActivity")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //instanciando os objetos da view
        txtPergunta = (TextView) findViewById(R.id.txtPergunta);

        radOpcoes = (RadioGroup) findViewById(R.id.radOpcoes);

        radOpcaoA = findViewById(R.id.radOpcaoA);
        radOpcaoB = findViewById(R.id.radOpcaoB);
        radOpcaoC = findViewById(R.id.radOpcaoC);

        btnOk = findViewById(R.id.btnOk);
        btnOk.setEnabled(false); //desabilita o botão até que uma opção seja selecionada

        atualizaPerguntas(btnOk);

        //ao selecionar uma opção dispara o log e armazena no número da pergunta o número da resposta
        /* é necessario númeroPergunta - 1 pois se trata de uma array com índice 0 e a função
        de atualizar a pergunta começa somando +1 na variável
         */
        radOpcoes.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radOpcaoA:
                        Log.d("s", "Opcao n1!");
                        listaRespostas[numeroPergunta - 1] = 1;
                        break;
                    case R.id.radOpcaoB:
                        Log.d("s", "Opcao n2!");
                        listaRespostas[numeroPergunta - 1] = 2;
                        break;
                    case R.id.radOpcaoC:
                        Log.d("s", "Opcao n3!");
                        listaRespostas[numeroPergunta - 1] = 3;
                        break;
                }
                btnOk.setEnabled(true); //habilita o botão ok após selecionar uma resposta
            }
        });

    }

    //FUNÇÕES


    public void checaResposta() {
        int contadorLista = 0;
        for(int numero : listaRespostas) { //cria variável número e atribui o valor da listaResposta recebida pelo botão
            System.out.println(numero);
            if(numero == listaGabarito[contadorLista]) {
                respostasCorretas++;
                System.out.println("Resposta Correta!");
            }
            else {
                System.out.println("Resposta Errada!");
            }
            contadorLista++;
        }
        alertaResultado(btnOk);
    }

    public void atualizaPerguntas(View view) {

        if(numeroPergunta == perguntas.length) { //se as perguntas acabarem checa o resultado
            checaResposta();
        }
        else {
            txtPergunta.setText(perguntas[numeroPergunta]);

            radOpcaoA.setText(OpcaoA[numeroPergunta]);
            radOpcaoB.setText(OpcaoB[numeroPergunta]);
            radOpcaoC.setText(OpcaoC[numeroPergunta]);

            numeroPergunta++;
            btnOk.setEnabled(false);
            radOpcoes.clearCheck();
        }
    }

    public void alertaResultado(View view) {
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage("Você acertou " + respostasCorretas + "perguntas!");
        alertDialog.show();

        radOpcaoA.setEnabled(false);
        radOpcaoB.setEnabled(false);
        radOpcaoC.setEnabled(false);
        radOpcoes.clearCheck();
        btnOk.setEnabled(false);
    }

}
