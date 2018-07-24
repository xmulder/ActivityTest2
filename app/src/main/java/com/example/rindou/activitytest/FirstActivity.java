package com.example.rindou.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);

        Button button1=(Button)findViewById(R.id.button_1);
        Button buttonIntent=(Button)findViewById(R.id.button_intent);
        Button buttonImplicitIntent=(Button)findViewById(R.id.button_intent_Implicit);
        final Button buttonImplicitMoreIntent=(Button)findViewById(R.id.button_intent_Implicit_More_Category);
        Button buttonIntentData=(Button)findViewById(R.id.button_intent_data);
        Button buttonIntentandBackwithData=(Button)findViewById(R.id.button_intent_for_back_with_data);

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(FirstActivity.this,"You clicked the Button 1.",Toast.LENGTH_LONG).show();
            }
        });

        buttonIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenttoSecondActivity=new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intenttoSecondActivity);
                Toast.makeText(FirstActivity.this,"Now you Intented to Second Activity.",Toast.LENGTH_LONG).show();
            }
        });

        buttonImplicitIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this,"Now you Intented to Third Activity.",Toast.LENGTH_LONG).show();
                Intent ImplicitIntent=new Intent("com.example.rindou.activitytest.ACTION_START");
                startActivity(ImplicitIntent);
            }
        });

        buttonImplicitMoreIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this,"Now you Intented to Fourth Activity.",Toast.LENGTH_LONG).show();
                Intent MoreImplicitIntent=new Intent("com.example.rindou.activitytest.fourthactivity.ACTION_START");
                MoreImplicitIntent.addCategory("com.example.rindou.activitytest.FourthActivity");
                startActivity(MoreImplicitIntent);
            }
        });

        buttonIntentData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String datai="Hello Intent Data to Fifth Activity";
                Intent DataIntentTest=new Intent(FirstActivity.this,FifthActivity.class);
                DataIntentTest.putExtra("data",datai);
                startActivity(DataIntentTest);
            }
        });

        buttonIntentandBackwithData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FirstActivity.this,SixthActivity.class);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(FirstActivity.this,"You clicked Add Item.",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(FirstActivity.this,"You clicked Remove Item.",Toast.LENGTH_LONG).show();
                break;
            case R.id.exit_item:
                Toast.makeText(FirstActivity.this,"Now you clicked Exit item and exit app.",Toast.LENGTH_LONG).show();
                finish();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}
