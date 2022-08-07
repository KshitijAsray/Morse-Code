package com.example.morsecodeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends lifecycleloggingactivity {
    private Button signup;
    private EditText email,password;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Initialize_views();
        auth = FirebaseAuth.getInstance();
        Register_activity();
    }
    protected void Initialize_views()
    {
        signup = findViewById(R.id.Sign_button);
        email = findViewById(R.id.editEmailAddress);
        password = findViewById(R.id.editPassword);
    }
    protected void Register_activity()
    {
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                Log.d(TAG,"Sign_Up Button Clicked");
                if(TextUtils.isEmpty(txt_email)||TextUtils.isEmpty(txt_password))
                    Toast.makeText(RegisterActivity.this,"Empty fields",Toast.LENGTH_SHORT).show();
                else if(txt_password.length()<=6)
                    Toast.makeText(RegisterActivity.this,"Password Too Short",Toast.LENGTH_SHORT).show();
                else
                    register_user(txt_email,txt_password);
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }

    protected void register_user(String txt_email, String txt_password)
    {
        auth.createUserWithEmailAndPassword(txt_email,txt_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                    Toast.makeText(RegisterActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(RegisterActivity.this,"Registration Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }
}