package com.example.elifozcevik.loginandregister;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Trainers extends AppCompatActivity {

    EditText e1, input;
    DatabaseHelper db;
    ListView listView;
    AlertDialog dialog;
    AlertDialog.Builder builder, builder2;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainers);
        db = new DatabaseHelper(this);
        listView = (ListView) findViewById(R.id.veriler);
        e1=(EditText)findViewById(R.id.editText7);
        delete=(Button)findViewById(R.id.delete);
        list();

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String surname = e1.getText().toString();
                db.veriSil(surname);
                list();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Enter Trainers Name and Surname");
                input = (EditText) new EditText(this);
                builder.setView(input);


                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        String text = input.getText().toString();
                        String[] text1=text.split(" ");
                        String name=text1[0];
                        String surname=text1[1];
                        db.veriEkle(name,surname);
                        //Ad soyad formatını boşlua göre parçala boşluktan öncesi ad sonrası soyad olsun

                        input.setText("");
                        list();

                    }
                });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                dialog = builder.create();
                dialog.show();
                list();


            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void list(){
        db = new DatabaseHelper(this);
        List<String> vVeriler =db.veriListele();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Trainers.this,android.R.layout.activity_list_item,android.R.id.text1,vVeriler);
        listView.setAdapter(adapter);
    }
}
