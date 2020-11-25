package com.example.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;


public class MainActivity extends AppCompatActivity {
Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btnreg);
        btn2=findViewById(R.id.btnlogin);

        //1st method
        FirebaseDatabase.getInstance().getReference().child("Users").child("Name").setValue("Aqib");

        //2nd Method
        HashMap<String,Object> map=new HashMap<>();
        map.put("Name","Intekhab");
        map.put("Email","inthekhab@aptech.com");

        FirebaseDatabase.getInstance().getReference().child("login").child("users").updateChildren(map);

        HashMap<String,Object> map1=new HashMap<>();
        map1.put("Name","Intekhab");
        map1.put("Email","inthekhab@aptech.com");
        FirebaseDatabase.getInstance().getReference().child("login").child("admin").updateChildren(map1);




        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,loginActivity.class));
            }
        });

    }
}