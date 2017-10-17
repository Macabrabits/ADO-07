package com.example.victorhugo.listviewcontatos;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.*;
import android.view.*;
import android.database.sqlite.*;
import android.database.*;

import com.example.victorhugo.listviewcontatos.DataBase.DataBase;
import com.example.victorhugo.listviewcontatos.Domain.RepositorioContato;


public class signUp extends AppCompatActivity implements View.OnClickListener {
    EditText numero2;
    ImageButton btnCreate2;
    DataBase dataBase;
    SQLiteDatabase conn;
    RepositorioContato repositorioContato;
    ArrayAdapter<String> adpContatos;

    private ArrayAdapter<String> adpName2;
    private ArrayAdapter<String> adpNumero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        numero2 = (EditText)findViewById(R.id.txtNumero2);
        btnCreate2 = (ImageButton)findViewById(R.id.btnCreate2);

        btnCreate2.setOnClickListener(this);

        try {

            dataBase = new DataBase(this);
            conn = dataBase.getWritableDatabase();

            repositorioContato = new RepositorioContato(conn);






            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Conexão criada com sucesso");
            dlg.setNeutralButton("Ok", null);
            //dlg.show();

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
        Log.i(numero2.toString(),numero2.toString());
        repositorioContato.testeInserirContatos(numero2.getText().toString());

    }




}
