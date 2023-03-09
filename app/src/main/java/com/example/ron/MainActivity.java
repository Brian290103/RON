package com.example.ron;

import androidx.activity.result.ActivityResultRegistryOwner;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

FirebaseAuth mAuth;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView txt_email = findViewById(R.id.email);
    TextView txt_password = findViewById(R.id.password);
    TextView signup =findViewById(R.id.signup);

    MaterialButton loginbtn =  findViewById(R.id.loginbtn);
    FirebaseAuth mAuth = FirebaseAuth.getInstance();

    signup.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(MainActivity.this,signup.class));
            finish();
        }
    });
    loginbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String email = txt_email.getText().toString();
            String password = txt_password.getText().toString();

            if(TextUtils.isEmpty(email)){
                 txt_email.setError("email cannnot be empty");
                txt_email.requestFocus();
            }else if(TextUtils.isEmpty(password)){
                txt_password.setError("password cannot be empty");
                txt_password.requestFocus();
            }else{
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "SUCCESSFUL", Toast.LENGTH_SHORT).show();
                        if(email && password == ){

                        }

                        startActivity(new Intent(MainActivity.this, Dashboard.class));
                    } else {
                        Toast.makeText(MainActivity.this, "failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });}}});}}


