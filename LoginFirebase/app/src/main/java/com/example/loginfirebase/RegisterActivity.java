package com.example.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
EditText email,pass;
Button regist;
FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.editTextemail);
        pass=findViewById(R.id.editTextpass);
        regist=findViewById(R.id.btnreg);
        auth=FirebaseAuth.getInstance();
        //optional
        ActivityCompat.requestPermissions(RegisterActivity.this,new String[]{Manifest.permission.INTERNET},1);

        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email=email.getText().toString();
                String txt_pass=pass.getText().toString();
                if(TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pass)){
                    Toast.makeText(RegisterActivity.this,"Empty Field",Toast.LENGTH_LONG).show();
                }
                if(txt_pass.length() <6 ){
                    Toast.makeText(RegisterActivity.this,"Too Short Password LEngth",Toast.LENGTH_LONG).show();
                }
                else {
                    UserRegister(txt_email,txt_pass);
                }


            }
        });

    }

    private void UserRegister(String txt_email, String txt_pass) {
        auth.createUserWithEmailAndPassword(txt_email, txt_pass).addOnCompleteListener(RegisterActivity.this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(RegisterActivity.this,"Register Successfully",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this,DashboardActivity.class));
                }
                else{
                    Toast.makeText(RegisterActivity.this,"Registration Failed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}