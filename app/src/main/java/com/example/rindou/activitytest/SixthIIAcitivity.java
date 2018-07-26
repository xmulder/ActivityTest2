package com.example.rindou.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SixthIIAcitivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixthii_layout);

        Button buttuonBacktoFirstActivity=(Button)findViewById(R.id.button_back_to_firstactivity_2);
        buttuonBacktoFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sixthiiIntent=new Intent();
                sixthiiIntent.putExtra("from_sixthii_to_first","From sixthii to first");
                setResult(RESULT_OK,sixthiiIntent);
                finish();
            }
        });
    }
}
