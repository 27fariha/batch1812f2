package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText etname,etsubj,etmarks;
Button ins,view,update,delete;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.editname);
        etsubj=findViewById(R.id.editsubject);
        etmarks=findViewById(R.id.editTextmarks);

        ins=findViewById(R.id.ins);
        view=findViewById(R.id.view);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.Del);
        createTable();

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("Insert into Student_data values('"+etname.getText().toString()+"','"+etsubj.getText().toString()+"','"+Integer.parseInt(etmarks.getText().toString())+"')");
                Toast.makeText(MainActivity.this,"Data Inserted Successfully",Toast.LENGTH_LONG).show();
                etname.setText("");
                etsubj.setText("");
                etmarks.setText("");
            }
        });
view.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i=new Intent(MainActivity.this,ViewDataActivity.class);
        startActivity(i);
    }
});

       

    }
    public void createTable() {
        db=openOrCreateDatabase("StudentDatabase",MODE_PRIVATE,null);
        db.execSQL("Create table IF NOT EXISTS Student_data( name varchar,subject varchar,marks int)");

    }

}