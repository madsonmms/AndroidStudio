package com.laranjas.felpudoinator;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Adaptador extends ArrayAdapter {


    public Adaptador(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View viewLista;
        viewLista = convertView;
        ViewPersonagem viewPersonagem;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewLista = inflater.inflate(R.layout.celula_lista,parent, false);

            viewPersonagem = new ViewPersonagem();
            viewPersonagem.icone = (ImageView) viewLista.findViewById(R.id.imgIcone);
            viewPersonagem.titulo = (TextView) viewLista.findViewById(R.id.txtTitulo);
            viewPersonagem.descricao = (TextView) viewLista.findViewById(R.id.txtDescricao);

            viewLista.setTag(viewPersonagem);

        }
        else {
            viewPersonagem = (ViewPersonagem) viewLista.getTag();
        }

        DadosPersonagem dadosPersonagem;
        dadosPersonagem = (DadosPersonagem)this.getItem(position);

        viewPersonagem.icone.setImageResource(dadosPersonagem.getIcone());
        viewPersonagem.titulo.setText(dadosPersonagem.getTitulo());
        viewPersonagem.descricao.setText(dadosPersonagem.getDescricao());

        return viewLista;
    }
}
