package com.example.projeto.bancodedados;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoDeDados {
    public SQLiteDatabase banco;
    public GerenciarBanco gerenciarBanco;

    public BancoDeDados(Context context){
        gerenciarBanco = new GerenciarBanco(context);
    }

    public boolean criarLista(String titulo, String conteudo){
        banco = gerenciarBanco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("conteudo", conteudo);

        long resultado = banco.insert("listas",null,valores);
        banco.close();

        return resultado>0;
    }

    public Cursor obterListas(){
        String[] campos = {"_id", "titulo"};
        SQLiteDatabase db = gerenciarBanco.getReadableDatabase();
        Cursor cursor = db.query("listas",campos, null,null,null,null,"titulo ASC");

        if(cursor != null){
            cursor.moveToFirst();
        }

        db.close();
        return cursor;
    }

    public Cursor consultarListaPeloId(int notaId){
        Cursor cursor;
        String[] campos = {"_id", "titulo", "conteudo"};
        String where ="_id = "+notaId;
        SQLiteDatabase db = gerenciarBanco.getReadableDatabase();
        cursor = db.query("listas",campos, where, null,null,null,null,null);

        if(cursor != null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void atualizaLista (int id, String titulo, String conteudo){
        SQLiteDatabase db = gerenciarBanco.getReadableDatabase();
        String where = "_id = "+id;

        ContentValues valores = new ContentValues();
        valores.put("titulo", titulo);
        valores.put("conteudo", conteudo);

        db.update("listas", valores, where, null);
        db.close();
    }

    public void excluiLista(int id){
        SQLiteDatabase db = gerenciarBanco.getReadableDatabase();
        String where ="_id = "+id;

        db.delete("listas", where, null);
        db.close();
    }


}
