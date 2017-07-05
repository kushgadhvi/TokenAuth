package com.gadhvi.token;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.Objects;

public class Register extends AppCompatActivity {
private EditText email,password,conf_password;
    Button b1;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b1=(Button)findViewById(R.id.submit1);
        email=(EditText)findViewById(R.id.email1);
        password=(EditText)findViewById(R.id.password1);
        conf_password=(EditText)findViewById(R.id.comfpassword);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Details");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Email = email.getText().toString().trim();
                String Password  = password.getText().toString().trim();
                String Conf_Pass =conf_password.getText().toString().trim();

                if(TextUtils.isEmpty(Email)){
                    Toast.makeText(Register.this,"Please enter email",Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(Password)){
                    Toast.makeText(Register.this,"Please enter password",Toast.LENGTH_LONG).show();
                    return;
                }

                if (!TextUtils.isEmpty(Email) && !TextUtils.isEmpty(Password) && Objects.equals(Password, Conf_Pass))
                {
                    progressDialog.setMessage("Registering Please Wait...");
                    progressDialog.show();


                   firebaseAuth.createUserWithEmailAndPassword(Email, Password)

                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {finish();
                                        String t1=FirebaseInstanceId.getInstance().getToken();
                                        Details d1 =new Details(Email,t1);
                                        mDatabase.push().setValue(d1);
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    } else {
                                        //display some message here
                                        Toast.makeText(Register.this, "Registration Error", Toast.LENGTH_LONG).show();
                                    }
                                    progressDialog.dismiss();
                                }
                            });

                }
                else {
                    Toast.makeText(Register.this,"Password Mismatch",Toast.LENGTH_LONG).show();
                }

            }
        });




    }
}
