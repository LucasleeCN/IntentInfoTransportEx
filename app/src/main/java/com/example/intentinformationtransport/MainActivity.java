package com.example.intentinformationtransport;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView textView_rec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* transport information to next activity*/
        Button button_sen = findViewById(R.id.button_sen);


        button_sen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String data = "hello SecondActivity!";
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
        /* transport information to next activity*/




        /* receive information from  previous activity*/
        Button button_rec = findViewById(R.id.button_rec);
        button_rec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });


    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        textView_rec= findViewById(R.id.textView_rec);
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData =data.getStringExtra("data_return");
                    textView_rec.setText(returnedData);

                }
                break;
            default:
        }

    }



    /* receive information from  previous activity*/
}


