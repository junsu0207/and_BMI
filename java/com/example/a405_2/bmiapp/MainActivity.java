package com.example.a405_2.bmiapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context ctx = MainActivity.this;
        final EditText height = findViewById(R.id.height);
        final EditText weight = findViewById(R.id.weight);
        final TextView result = findViewById(R.id.result);

        /*고도 비만 : 40 이상
        중등도 비만 (2단계 비만) : 35 - 39.9
        경도 비만 (1단계 비만) : 30 - 34.9
        과체중 : 25 - 29.9
        정상 : 18.5 - 24.9
        저체중 : 18.5 미만*/

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double dHeight = Double.parseDouble(height.getText().toString());
                double dWeight = Double.parseDouble(weight.getText().toString());

                double bmi = dWeight / ((dHeight * dHeight)/10000);
                String res = "";
                if(bmi >= 40){
                    Toast.makeText(ctx, "고도비만"+bmi, Toast.LENGTH_LONG).show();
                    res = "고도비만";
                }else if(bmi >= 35){
                    Toast.makeText(ctx, "중증도비만"+bmi, Toast.LENGTH_LONG).show();
                    res= "중증도 비만";
                }else if (bmi >= 30) {
                    Toast.makeText(ctx, "경도비만"+bmi, Toast.LENGTH_LONG).show();
                    res = "경도비만";
                }else if(bmi >= 25){
                    Toast.makeText(ctx, "과체중"+bmi, Toast.LENGTH_LONG).show();
                    res = "과체중";
                }else if(bmi >=18.5){
                    Toast.makeText(ctx, "정상"+bmi, Toast.LENGTH_LONG).show();
                    res = "정상";
                }else{
                    Toast.makeText(ctx, "저체중"+bmi, Toast.LENGTH_LONG).show();
                    res = "저체중";
                }
                result.setText(res);
            }

        });

    }
}
