package com.example.project2application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
            Button mlogin;
            EditText mPassword, mEmail;
            TextView mC;
            ProgressBar mProgressBar;
            FirebaseAuth fAuth;
            FirebaseFirestore fStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

         mC = findViewById(R.id.C);
         mlogin = findViewById(R.id.login);
         mPassword = findViewById(R.id.Password);
         mEmail = findViewById(R.id.Email);
         mProgressBar = findViewById(R.id.progressBar);
         fAuth = FirebaseAuth.getInstance();
         fStore = FirebaseFirestore.getInstance();

        mC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
         mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = mEmail.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    mEmail.setError("Email is required.");
                    return;
                }

                if(TextUtils.isEmpty((Password))){
                    mPassword.setError("Password is required.");
                    return;

                }

                if(Password.length() < 6){
                    mPassword.setError("Password has to be longer than 6 characters.");
                    return;

                }

                mProgressBar.setVisibility(View.VISIBLE);
                fAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                            //transition to details page and car manipulation page (enter car details/show list of cars)
                            startActivity(new Intent(getApplicationContext(), CarMenu.class));
                        } else{
                            Toast.makeText(LoginActivity.this,"Error !"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            mProgressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });
    }
}
