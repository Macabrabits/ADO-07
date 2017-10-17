package com.example.victorhugo.listviewcontatos;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.database.sqlite.*;
import android.database.*;

import com.example.victorhugo.listviewcontatos.DataBase.DataBase;
import com.example.victorhugo.listviewcontatos.Domain.RepositorioContato;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnAdd;
    ListView lstContatos;
    EditText txtName;
    DataBase dataBase;
    SQLiteDatabase conn;
    RepositorioContato repositorioContato;
    ArrayAdapter<String> adpContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (ImageButton)findViewById(R.id.btnAdd);
        lstContatos = (ListView)findViewById(R.id.lstContatos);
        txtName = (EditText)findViewById(R.id.txtName);
        btnAdd.setOnClickListener(this);

        try {

            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioContato = new RepositorioContato(conn);

            //repositorioContato.testeInserirContatos("44444444");

            adpContatos = repositorioContato.buscaContatos(this);

            lstContatos.setAdapter(adpContatos);

            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso");
            dlg.setNeutralButton("Ok", null);
            dlg.show();

        }catch(SQLException ex)
        {
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro ao criar o banco: " + ex.getMessage());
            dlg.setNeutralButton("Ok", null);
            dlg.show();
        }



    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(this,signUp.class);
        startActivity(intent);
    }


}
