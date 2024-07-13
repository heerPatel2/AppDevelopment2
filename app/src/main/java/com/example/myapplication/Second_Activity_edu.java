package com.example.myapplication;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Second_Activity_edu extends AppCompatActivity {

    TextView title;
//    TextView secTitle, ThirdTitle, fourthTitle;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_edu);

        title = findViewById(R.id.sec_title);
//        secTitle = findViewById(R.id.sec_title);
//        ThirdTitle = findViewById(R.id.third_title);
//        fourthTitle = findViewById(R.id.fourth_title);
        imageView=findViewById(R.id.image);

        title.setText(getIntent().getExtras().getString("title"));
        int foodimg = getIntent().getIntExtra("foodimg",0);
        imageView.setImageResource(foodimg);
    }
}


