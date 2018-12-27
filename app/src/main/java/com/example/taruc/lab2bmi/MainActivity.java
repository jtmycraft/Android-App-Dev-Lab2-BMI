package com.example.taruc.lab2bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {
    private EditText editTextHeight,editTextWeight;
    public static final String EXTRA_MESSAGE = "com.example.taruc.lab2bmi.Message";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWight);
    }

    public void calculateBMI(View view){
        double weight,height,BMI;
        weight = Double.parseDouble(editTextWeight.getText().toString());
        height = Double.parseDouble(editTextHeight.getText().toString());

        BMI = weight / pow(height,2);

        Intent intent = new Intent(this,Main2Activity.class);
        String message;
        if(BMI<18.5){
            message = "Underweight";
            intent.putExtra(EXTRA_MESSAGE,message);
            Log.d("MainActivity",message);
            startActivity(intent);
        }
        else if(BMI>24.5){
            message = "Overweight";
            intent.putExtra(EXTRA_MESSAGE,message);
            Log.d("MainActivity",message);
            startActivity(intent);
        }
        else{
            message = "Normal";
            intent.putExtra(EXTRA_MESSAGE,message);
            Log.d("MainActivity",message);
            startActivity(intent);
        }


    }
}
