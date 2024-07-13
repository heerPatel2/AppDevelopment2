package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class InsuranceArticlesDetailsActicity extends AppCompatActivity {

    TextView tv1;
    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance_articles_details_acticity);

        tv1=findViewById(R.id.textViewIAD);
        img=findViewById(R.id.imageViewIAD);
        btn=findViewById(R.id.buttonIAD);


        Intent intent=getIntent();
        tv1.setText(intent.getStringExtra("text1"));

        Bundle bundle=getIntent().getExtras();
        if(bundle!=null)
        {
            int resId =bundle.getInt("text2");
            img.setImageResource(resId);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsuranceArticlesDetailsActicity.this, InsuranceActivity2.class));
            }
        });


    }
}