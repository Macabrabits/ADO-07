package com.example.victorhugo.listviewcontatos;

/**
 * Created by Victor Hugo on 10/10/2017.
 */




public class ScriptSQL {

    public static String getCreateContato(){
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("CREATE TABLE IF NOT EXISTS CONTATO ( ");
        sqlBuilder.append("_id                INTEGER       NOT NULL ");
        sqlBuilder.append("PRIMARY KEY AUTOINCREMENT, ");
        sqlBuilder.append("TELEFONE           VARCHAR (14) ");
        sqlBuilder.append("); ");

        return sqlBuilder.toString();


    }

}
