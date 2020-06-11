package com.example.projeto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto.bancodedados.BancoDeDados;

public class EditarLista extends Activity {

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_lista);

        this.mViewHolder.editTitulo = findViewById(R.id.edit_campo_titulo);
        this.mViewHolder.editConteudo = findViewById(R.id.edit_campo_conteudo);

        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        final Cursor cursor = bancoDeDados.consultarListaPeloId(this.getIntent().getIntExtra("id",0));

        //EditText titulo = (EditText) findViewById(R.id.campoTitulo);
        //EditText conteudo = (EditText) findViewById(R.id.campoConteudo);

        this.mViewHolder.editTitulo.setText(cursor.getString(cursor.getColumnIndexOrThrow("titulo")));
        this.mViewHolder.editConteudo.setText(cursor.getString(cursor.getColumnIndexOrThrow("conteudo")));
    }

    public void voltar (View v) {
        Intent startNewActivity = new Intent(this, MainActivity.class);
        startActivity(startNewActivity);
    }

    public void atualizarLista (View v){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        //EditText titulo = (EditText) findViewById(R.id.campoTitulo);
        //EditText conteudo = (EditText) findViewById(R.id.campoConteudo);

        try{
            bancoDeDados.atualizaLista(
                    this.getIntent().getIntExtra("id",0),
                    this.mViewHolder.editTitulo.getText().toString(),
                    this.mViewHolder.editConteudo.getText().toString());
            Toast.makeText(getApplicationContext(), "Lista Atualizada com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Não foi possível atualizar a Lista", Toast.LENGTH_LONG).show();
        }
        voltar(v);
    }

    public void excluirLista (View v){
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());
        //EditText titulo = (EditText) findViewById(R.id.campoTitulo);
        //EditText conteudo = (EditText) findViewById(R.id.campoConteudo);

        try{
            bancoDeDados.excluiLista(this.getIntent().getIntExtra("id",0));
            Toast.makeText(getApplicationContext(), "Lista Excluida com Sucesso!", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Não foi possível excluir a Lista", Toast.LENGTH_LONG).show();
        }
        voltar(v);
        }

        private static class ViewHolder {
            EditText editTitulo;
            EditText editConteudo;
        }
    }

