package com.example.rindou.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ItemActivity_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_4);

        Intent intent4=getIntent();
        String data4=intent4.getStringExtra("implicitdataitem");
        Toast.makeText(ItemActivity_4.this,data4,Toast.LENGTH_LONG).show();
        Log.d("Item Acitivity 4",data4);
    }
}
