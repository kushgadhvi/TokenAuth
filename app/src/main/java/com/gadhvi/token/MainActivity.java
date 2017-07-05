package com.gadhvi.token;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {
DatabaseReference mDatabase;
TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   /*     Toast.makeText(this, "token "+ FirebaseInstanceId.getInstance().getToken(), Toast.LENGTH_SHORT).show();
        Log.d("My Token", "Refreshed token: " + FirebaseInstanceId.getInstance().getToken());
        t1=(TextView)findViewById(R.id.text);
        t1.setText("token"+ FirebaseInstanceId.getInstance().getToken());
        mDatabase =FirebaseDatabase.getInstance().getReference().child("Token");
        mDatabase.push().setValue(FirebaseInstanceId.getInstance().getToken());*/

    }


}
