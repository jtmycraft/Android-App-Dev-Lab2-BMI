package com.example.taruc.lab2bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private ImageView imageViewBMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        imageViewBMI = findViewById(R.id.imageViewBMI);

        //assign drawtable to an image view
        imageViewBMI.setImageResource(R.drawable.empty);
        TextView textViewMessage;
        textViewMessage = findViewById(R.id.textViewMessage);
        Intent intent = getIntent();
        if(intent.hasExtra(MainActivity.EXTRA_MESSAGE)) {
            String message;
            message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
            textViewMessage.setText(message);
        }

        if(textViewMessage.getText().equals("Normal")){
            imageViewBMI.setImageResource(R.drawable.normal);
        }      else  if(textViewMessage.getText().equals("Underweight")){
            imageViewBMI.setImageResource(R.drawable.under);
        }      else  if(textViewMessage.getText().equals("Overweight")){
            imageViewBMI.setImageResource(R.drawable.over);
        }

    }

    public void CloseActivity(View view){
        finish();
    }
}