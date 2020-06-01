package com.laranjas.felpudoinator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] listaNomes = {"Felpudo","Fofura","Lesmo",
            "Bugado","Uruca","Racing",
            "iOS","Android", "RealidadeAumentada",
            "Sound FX","3D Studio Max","Games"};

    String[] listaDescricao = {"Felpudo","Fofura","Lesmo",
            "Bugado","Uruca","Racing",
            "iOS","Android", "RealidadeAumentada",
            "Sound FX","3D Studio Max","Games"};

    int[] listaIcones = {R.drawable.felpudo,R.drawable.fofura,R.drawable.lesmo,
            R.drawable.bugado, R.drawable.uruca, R.drawable.carrinho,
            R.drawable.ios, R.drawable.android, R.drawable.realidade_aumentada,
            R.drawable.sound_fx, R.drawable.max, R.drawable.games,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Adaptador adaptador;

        //Lista com Layout modificado
        ListView lstLista = findViewById(R.id.lstLista);

        adaptador = new Adaptador(getApplicationContext(), R.layout.celula_lista);

        int i = 0;

        for(String nome:listaNomes) {
            DadosPersonagem dadosPersonagem;
            dadosPersonagem = new DadosPersonagem(listaIcones[i],nome,listaDescricao[i]);
            adaptador.add(dadosPersonagem);
            i++;
        }

        lstLista.setAdapter(adaptador);

        /*
        FORMA DE FAZER LISTA SIMPLES

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,android.R.id.text1, listaNomes);

        ListView lstLista = findViewById(R.id.lstLista);
        lstLista.setAdapter(adaptador);

        lstLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, ""+listaNomes[position], Toast.LENGTH_SHORT).show();
            }
        });*/

        lstLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DadosPersonagem dadosPersonagem;
                dadosPersonagem = (DadosPersonagem) adaptador.getItem(position);

                alertaPersonagem(dadosPersonagem);
            }
        });
    }

    void alertaPersonagem(DadosPersonagem dadosPersongem) {

        AlertDialog.Builder alerta;
        alerta = new AlertDialog.Builder(MainActivity.this);

        alerta.setTitle(dadosPersongem.getTitulo());
        alerta.setTitle(dadosPersongem.getDescricao());

        alerta.setCancelable(true);
        alerta.setIcon(dadosPersongem.getIcone());

        alerta.setPositiveButton("Confirma", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Confirma!", Toast.LENGTH_SHORT).show();
            }
        });

        alerta.create();
        alerta.show();

    }

}
