package com.example.elifozcevik.loginandregister;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Workouts extends AppCompatActivity {

    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workouts);
        b1=(Button)findViewById(R.id.back);
        b2=(Button)findViewById(R.id.biceps);
        b3=(Button)findViewById(R.id.arms);
        b4=(Button)findViewById(R.id.legs);
    }

    public void b1(View view){
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=yuX7uVOa0sE");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);

    }
    public void b2(View v){
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=CLccU7tk7es");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }
    public void b3(View v){
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=hAGfBjvIRFI");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }

    public void b4(View v) {
        Uri uri = Uri.parse("https://www.youtube.com/watch?v=Womx4TM6p3A");
        Intent it = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(it);
    }
}
