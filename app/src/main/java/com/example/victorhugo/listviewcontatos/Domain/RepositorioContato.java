package com.example.victorhugo.listviewcontatos.Domain;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

/**
 * Created by Victor Hugo on 17/10/2017.
 */

public class RepositorioContato {

    private SQLiteDatabase conn;

    public RepositorioContato(SQLiteDatabase conn){
        this.conn = conn;
    }



    public void testeInserirContatos(String numeroContato){


        ContentValues values = new ContentValues();
        values.put("TELEFONE", numeroContato);
        conn.insertOrThrow("CONTATO", null, values);

    }



    public ArrayAdapter<String> buscaContatos(Context context){
        ArrayAdapter<String> adpContatos = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1);
        Cursor cursor = conn.query("CONTATO", null, null, null, null, null, null);
        if(cursor.getCount()>0)
        {

            cursor.moveToFirst();

            while(cursor.moveToNext()) {
                String telefone = cursor.getString(1);
                adpContatos.add(telefone);
            }
        }
        return adpContatos;
    }
}
