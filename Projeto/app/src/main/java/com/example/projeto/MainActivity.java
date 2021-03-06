package com.example.projeto;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projeto.bancodedados.BancoDeDados;

public class MainActivity extends Activity implements
        AdapterView.OnItemClickListener,
        View.OnClickListener {

    //Instanciando ViewHolder
    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nomeCampos = new String[]{"_id", "titulo"};
        BancoDeDados bancoDeDados = new BancoDeDados(getBaseContext());

        //Atribuindo os IDs as variáveis do ViewHolder
        this.mViewHolder.cursor = bancoDeDados.obterListas();
        this.mViewHolder.listLista = findViewById(R.id.list_compras);
        this.mViewHolder.buttonCriarLista = findViewById(R.id.button_criar_lista);
        this.mViewHolder.idViews = new int[]{
                R.id.label_id, R.id.label_titulo};
        this.mViewHolder.adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.modelo_lista,
                this.mViewHolder.cursor,
                nomeCampos,
                this.mViewHolder.idViews, 0);

        //Atribuindo eventos de click
        this.mViewHolder.listLista.setAdapter(this.mViewHolder.adaptador);
        this.mViewHolder.listLista.setOnItemClickListener(this);
        this.mViewHolder.buttonCriarLista.setOnClickListener(this);

    }

    //Configuração no click no item da lista
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        this.mViewHolder.cursor.moveToPosition(position);
        Intent intent = new Intent(MainActivity.this, EditarLista.class);
        intent.putExtra("id",
                this.mViewHolder.cursor.getInt(this.mViewHolder.cursor.getColumnIndexOrThrow("_id")));
        startActivity(intent);
        finish();
    }

    //Configuração do click no botão de criar lista
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_criar_lista) {
            Intent startNewActivity = new Intent(this, CriarLista.class);
            startActivity(startNewActivity);
        }
    }

    //Criação do ViewHolder
    public static class ViewHolder {
        ListView listLista;
        SimpleCursorAdapter adaptador;
        int[] idViews;
        Cursor cursor;
        ImageButton buttonCriarLista;
    }

}