package com.example.victorhugo.listviewcontatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class signUp extends AppCompatActivity {
    EditText txtNome2, numero2;
    ImageButton btnCreate2;

    private ArrayAdapter<String> adpName2;
    private ArrayAdapter<String> adpNumero2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtNome2 = (EditText)findViewById(R.id.txtName2);
        numero2 = (EditText)findViewById(R.id.txtNumero2);
        btnCreate2 = (ImageButton)findViewById(R.id.btnCreate2);
    }
}
