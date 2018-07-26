package com.example.rindou.activitytest;

import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ItemActivity_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_3);

        Intent item_data_intent=getIntent();
        String data=item_data_intent.getStringExtra("itemdata");
        Toast.makeText(ItemActivity_3.this,data,Toast.LENGTH_LONG).show();
        Log.d("Item Acitivity 3",data);
    }
}
