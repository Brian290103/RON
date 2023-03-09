package com.example.ron;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        TextView txt_email = findViewById(R.id.email);
        TextView txt_password = findViewById(R.id.password);
        TextView txt_cpassword = findViewById(R.id.confirmpassword);
        TextView signin =findViewById(R.id.signin);

        MaterialButton loginbtn =  findViewById(R.id.registerbtn);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

       signin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(signup.this,MainActivity.class));
               finish();
           }
       });
       loginbtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String email = txt_email.getText().toString();
               String password = txt_password.getText().toString();
               mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           Toast.makeText(signup.this, "SUCCESSFUL", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(signup.this, MainActivity.class));
                       } else {
                           Toast.makeText(signup.this, "failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });}});}}