package com.example.elifozcevik.loginandregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ForgetPassword extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    String mail="";
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.password);
        b1=(Button)findViewById(R.id.reset);



        db=new DatabaseHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myInten=new Intent(ForgetPassword.this, ConfirmPassword.class);
                myInten.putExtra("mail",e1.getText().toString());
                startActivityForResult(myInten,300);
            }
        });
    }
}
