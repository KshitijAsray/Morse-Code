package com.example.morsecodeapp;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends lifecycleloggingactivity
{
    private Button login;
    private EditText email,password;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        auth = FirebaseAuth.getInstance();
        Initialize_views();
    }
    protected void Initialize_views()
    {
        login = findViewById(R.id.login_button);
        email = findViewById(R.id.editEmailAddress);
        password = findViewById(R.id.editPassword);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password))
                    Toast.makeText(LoginActivity.this,"Empty Fields",Toast.LENGTH_SHORT).show();
                else
                    setLogin(txt_email,txt_password);
            }
        });
    }
    protected void setLogin(String txt_email,String txt_password)
    {
        auth.signInWithEmailAndPassword(txt_email,txt_password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult)
            {
                Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,code.class));
            }
        });
    }
}