package com.example.projeto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.projeto.R;
import com.example.projeto.bancodedados.BancoDeDados;

public class CriarLista extends Activity implements View.OnClickListener {

    //Instanciando ViewHolder
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);

        //Atribuindo os IDs as variáveis do ViewHolder
        this.mViewHolder.editTitulo = findViewById(R.id.edit_titulo);
        this.mViewHolder.editConteudo = findViewById(R.id.edit_conteudo);
        this.mViewHolder.buttonCriarLista = findViewById(R.id.button_criar_lista);
        this.mViewHolder.buttonCancelar = findViewById(R.id.button_cancelar);

        //Atribuindo eventos de click
        this.mViewHolder.buttonCriarLista.setOnClickListener(this);
        this.mViewHolder.buttonCancelar.setOnClickListener(this);

        //Para focar no título ao abrir a Activity
        this.mViewHolder.editTitulo.requestFocus();
    }

    //Configurando os clicks da Activity
    @Override
    public void onClick(View v) {

        Intent startNewActivity = new Intent(this, MainActivity.class);

        switch (v.getId()) {
            case R.id.button_cancelar:
                startActivity(startNewActivity);
                break;

            case R.id.button_criar_lista:
                BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());

                boolean resultado = bancoDeDados.criarLista(
                        this.mViewHolder.editTitulo.getText().toString(),
                        this.mViewHolder.editConteudo.getText().toString()
                );

                if (resultado) {
                    Toast.makeText(getApplicationContext(), "Lista Criada com Sucesso", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Erro ao Criar Lista", Toast.LENGTH_LONG).show();
                }
                startActivity(startNewActivity);
                break;
        }
    }

    //Criação do ViewHolder
    private static class ViewHolder {
        EditText editTitulo;
        EditText editConteudo;
        ImageButton buttonCriarLista;
        ImageButton buttonCancelar;
    }
}

/*--------------TRECHOS REMOVIDOS----------------*/

    /*
    public void voltar (View v){
        Intent startNewActivity = new Intent(this, MainActivity.class);
        startActivity(startNewActivity);
    }
    */

    /*
    public void criarLista (View v){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        //EditText titulo = (EditText) findViewById(R.id.campoTitulo);
        //EditText conteudo = (EditText) findViewById(R.id.campoConteudo);

        boolean resultado = bancoDeDados.criarLista(
                this.mViewHolder.editTitulo.getText().toString(),
                this.mViewHolder.editConteudo.getText().toString()
        );

        if(resultado) {
            Toast.makeText(getApplicationContext(), "Lista Criada com Sucesso", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Erro ao Criar Lista", Toast.LENGTH_LONG).show();
        }

        voltar (v);

    }

     */