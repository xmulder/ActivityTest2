package com.example.rindou.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class FifthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fifth_layout);

        Intent intent=getIntent();
        String data=intent.getStringExtra("data");
        Toast.makeText(FifthActivity.this,data+"!Sescusslly.",Toast.LENGTH_LONG).show();
        //Toast.makeText(FifthActivity.this,"Sesscufully.",Toast.LENGTH_LONG).show();
        Log.d("Fifth Activity",data);
    }
}
