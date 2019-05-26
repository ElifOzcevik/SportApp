package com.example.elifozcevik.loginandregister;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class List extends AppCompatActivity {

    Button b1;
    ListView list;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        b1=(Button)findViewById(R.id.button);
        list=(ListView)findViewById(R.id.veriler);
        db=new DatabaseHelper(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                java.util.List<String> vVeriler =db.list();
                ArrayAdapter<String> adapter=new ArrayAdapter<String>(List.this,android.R.layout.activity_list_item,android.R.id.text1,vVeriler);
                list.setAdapter(adapter);
            }
        });
    }
}
