package com.example.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DashboardActivity extends AppCompatActivity {
Button btn1,ins;
FirebaseAuth auth;
EditText et;
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        btn1=findViewById(R.id.button);
        et=findViewById(R.id.editTextTextPersonName);
        ins=findViewById(R.id.button2);
        lv=findViewById(R.id.list);
        auth=FirebaseAuth.getInstance();


        ArrayList list=new ArrayList<>();
        ArrayAdapter adp=new ArrayAdapter<String>(DashboardActivity.this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adp);

        DatabaseReference ref=FirebaseDatabase.getInstance().getReference("Languages");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            list.clear();
            for(DataSnapshot snap : snapshot.getChildren()){
                list.add(snap.getValue().toString());
            }
            adp.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_val=et.getText().toString();
                if(TextUtils.isEmpty(txt_val)){
                    Toast.makeText(DashboardActivity.this,"Empty",Toast.LENGTH_LONG).show();
                }
                else{
                    FirebaseDatabase.getInstance().getReference().child("Languages").push().child("name").setValue(txt_val);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                startActivity(new Intent(DashboardActivity.this,MainActivity.class));
            }
        });

    }
}