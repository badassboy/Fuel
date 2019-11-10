package com.example.fuel;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText inputEmail,inputPassword;
    private Button signUp;
    private FirebaseAuth auth;
    private String email,pwd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Toolbar toolbar = (Toolbar)findViewById(R.id.signup_toolbar);
//        setSupportActionBar(toolbar);
            toolbar.setTitle("REGISTER HERE");
//        Get firebase auth instance
        auth = FirebaseAuth.getInstance();

        inputEmail = (EditText)findViewById(R.id.email);
        inputPassword = (EditText)findViewById(R.id.password);
        signUp = (Button)findViewById(R.id.sign_up_button);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });



    }

    private void  registerUser(){
        email = inputEmail.getText().toString();
        pwd = inputPassword.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(pwd)){
            Toast.makeText(getApplicationContext(),"fields are required",Toast.LENGTH_SHORT).show();
        }else {
            auth.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(),"authentication failed: "+ task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
