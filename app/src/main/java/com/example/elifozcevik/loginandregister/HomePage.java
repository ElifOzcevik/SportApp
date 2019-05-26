package com.example.elifozcevik.loginandregister;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    EditText e1,e2,e3,e4;
    Button b1;
    String mail="";
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        e1=(EditText)findViewById(R.id.email);
        e2=(EditText)findViewById(R.id.password);
        e3=(EditText)findViewById(R.id.cpass);
        e4=(EditText)findViewById(R.id.olpass);
        b1=(Button)findViewById(R.id.reset);
        Intent myIntent=getIntent();
        mail=(myIntent.getStringExtra("mail"));
        e1.setText(mail);
        db=new DatabaseHelper(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (e1.equals("") || e2.equals("") || e3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                }
                Boolean chkemailpassword = db.chkemailpassword(mail, e4.getText().toString());
                if (chkemailpassword == true) {
                  if (e2.getText().toString().equals(e3.getText().toString())) {
                        db.updatePassword(mail, e2.getText().toString().trim());
                        Toast.makeText(getApplicationContext(), "Update successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                      Toast.makeText(getApplicationContext(),"Update failed! Try Again",Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(getApplicationContext(),"Wrong password",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
