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

public class CriarLista extends Activity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_lista);

        this.mViewHolder.editTitulo = findViewById(R.id.edit_campo_titulo);
        this.mViewHolder.editConteudo = findViewById(R.id.edit_campo_titulo);
        this.mViewHolder.button_criar_lista = findViewById(R.id.button_criar_lista);
        this.mViewHolder.button_criar_lista = findViewById(R.id.button_cancelar);

    }

    public void voltar (View v){
        Intent startNewActivity = new Intent(this, MainActivity.class);
        startActivity(startNewActivity);
    }

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

    private static class ViewHolder {
        EditText editTitulo;
        EditText editConteudo;
        ImageButton button_criar_lista;
        ImageButton button_cancelar;
    }
}
