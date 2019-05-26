package com.example.elifozcevik.loginandregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BMI extends AppCompatActivity {

    EditText weight,height;
    Button calculate;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        weight=(EditText)findViewById(R.id.editText);
        height=(EditText)findViewById(R.id.editText2);
        calculate=(Button)findViewById(R.id.button);
        text=(TextView)findViewById(R.id.textView);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x=Double.parseDouble(weight.getText().toString());
                double y=Double.parseDouble(height.getText().toString());
                double bmi=x/(y*y);

                if (18.5>bmi){
                    text.setText(String.valueOf(bmi)+"\n Zayıf!");
                }
                else if(bmi<24.9){
                    text.setText(String.valueOf(bmi)+"\n İdeal!");
                }
                else if(bmi<29.9){
                    text.setText(String.valueOf(bmi)+"\n Kilolu!");
                }
                else
                    text.setText(String.valueOf(bmi)+"\n Obez!");

            }
        });

    }



}
