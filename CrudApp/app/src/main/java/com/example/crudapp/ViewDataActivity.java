package com.example.crudapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewDataActivity extends AppCompatActivity {
ListView list;
ArrayList<String> student;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
        createTable();
        list=findViewById(R.id.list);
        GetData();
    }
public void GetData(){
    String query = "Select * from Student_data";

    Cursor cr;
    cr = db.rawQuery(query, null);
    student = new ArrayList<String>();
    while (cr.moveToNext()) {
        String name = cr.getString(0); //index
        String subject = cr.getString(1);
        String marks = cr.getString(2);
        student.add(name + "\n" + subject +"\n"+ marks);
    }
    ArrayAdapter<String> l = new ArrayAdapter<String>(ViewDataActivity.this, android.R.layout.simple_list_item_1, student);
    list.setAdapter(l);
}

    public void createTable() {
        db=openOrCreateDatabase("StudentDatabase",MODE_PRIVATE,null);
        db.execSQL("Create table IF NOT EXISTS Student_data( name varchar,subject varchar,marks int)");

    }
}