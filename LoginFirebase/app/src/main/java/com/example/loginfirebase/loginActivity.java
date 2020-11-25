package com.example.loginfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
EditText email,pass;
Button login;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.editTextemail);
        pass=findViewById(R.id.editTextpass);
        login=findViewById(R.id.btnlog);
        auth=FirebaseAuth.getInstance();

      login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            String txt_email=email.getText().toString();
            String txt_pass=pass.getText().toString();
            UserLogin(txt_email,txt_pass);
          }
      });

    }

    private void UserLogin(String txt_email, String txt_pass) {
        auth.signInWithEmailAndPassword(txt_email, txt_pass).addOnSuccessListener(loginActivity.this, new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(loginActivity.this,"Login Successfull",Toast.LENGTH_LONG).show();
                startActivity(new Intent(loginActivity.this,DashboardActivity.class));
            }
        });
    }
}