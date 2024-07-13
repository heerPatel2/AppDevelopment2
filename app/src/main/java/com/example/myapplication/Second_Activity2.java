package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Second_Activity2 extends AppCompatActivity {
    TextView title2;
    ImageView imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        title2 = findViewById(R.id.sec_title_2);
        imageView2 = findViewById(R.id.sec_img2);

        title2.setText(getIntent().getExtras().getString("title"));
        int foodimg2 = getIntent().getIntExtra("foodimg2",0);
        imageView2.setImageResource(foodimg2);
       }
}