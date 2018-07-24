package com.example.rindou.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sixth_layout);

        Button BacktoFirstActivity=(Button)findViewById(R.id.button_back_to_firstactivity);
        BacktoFirstActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SixthActivity.this,FirstActivity.class);
                intent.putExtra("back_to_firstactivity","Back form SixthActivity to FirstActivity.");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
