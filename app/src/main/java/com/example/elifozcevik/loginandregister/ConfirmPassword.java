package com.example.elifozcevik.loginandregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ConfirmPassword extends AppCompatActivity {

    EditText e1,e2;
    Button b1;
    String mail;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_password);
        e1=(EditText)findViewById(R.id.editText5);
        e2=(EditText)findViewById(R.id.editText6);
        b1=(Button)findViewById(R.id.button3);
        db=new DatabaseHelper(this);
        Intent myIntent=getIntent();
        mail=(myIntent.getStringExtra("mail"));

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (e1.equals("") || e2.equals("") ){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else if (e1.getText().toString().equals(e2.getText().toString())){
                   // Boolean chkemail=db.chkemail(mail);
                    //if (chkemail==true){
                        db.updatePassword(mail,e1.getText().toString());
                        Toast.makeText(getApplicationContext(), "password reset successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ConfirmPassword.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                   // }
                    //else {
                    //    Toast.makeText(getApplicationContext(), "Email don't found. You should register.", Toast.LENGTH_SHORT).show();
                    //}
                }
                else Toast.makeText(getApplicationContext(),"Password do not match",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
