package com.example.rindou.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
        Button buttonImplicitIntentforBackwithData=(Button)findViewById(R.id.button_implicit_intent_for_back_with_data);

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
                Toast.makeText(FirstActivity.this,"Now From FirstActivity to SixthActivity.",Toast.LENGTH_LONG).show();
                startActivityForResult(intent,1);
            }
        });

        buttonImplicitIntentforBackwithData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sixthiiToast="This Button is Implicit Intent with Data from FirstActivity to SixthIIActivity.";
                Toast.makeText(FirstActivity.this,sixthiiToast,Toast.LENGTH_LONG).show();
                Intent implicitIntentwithData=new Intent("com.example.rindou.activitytest.sixthiiactivity.ACTION_START");
                implicitIntentwithData.addCategory("android.intent.category.activitytest.SixthiiActivity");
                startActivityForResult(implicitIntentwithData,2);
            }
        });

    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnData=data.getStringExtra("back_to_firstactivity");
                    Toast.makeText(FirstActivity.this,returnData,Toast.LENGTH_LONG).show();
                    Log.d("First Activity",returnData);
                }
            case 2:
                if(resultCode==RESULT_OK){
                    String returnData2=data.getStringExtra("from_sixthii_to_first");
                    Toast.makeText(FirstActivity.this,returnData2,Toast.LENGTH_LONG).show();
                    Log.d("First Activity",returnData2);
                }
        }
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
            case R.id.intent_item:
                Toast.makeText(FirstActivity.this,"Item Intent test.",Toast.LENGTH_LONG).show();
                Intent intentItem_1=new Intent(FirstActivity.this,ItemActivity_1.class);
                startActivity(intentItem_1);
                break;
            case R.id.implicit_intent_item:
                Toast.makeText(FirstActivity.this,"Implicit Intent for Item.",Toast.LENGTH_LONG).show();
                Intent implicit_intent_item=new Intent("android.intent.action.ACTION_START");
                implicit_intent_item.addCategory("android.intent.category.IMPLICIT_INTENT_ITEM");
                startActivity(implicit_intent_item);
                break;
            case R.id.intent_data_item:
                String item_data="Test Item Intent with data.";
                Intent item_data_intent=new Intent(FirstActivity.this,ItemActivity_3.class);
                item_data_intent.putExtra("itemdata",item_data);
                startActivity(item_data_intent);
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
