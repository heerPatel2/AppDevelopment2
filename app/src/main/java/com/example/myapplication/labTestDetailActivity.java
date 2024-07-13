package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class labTestDetailActivity extends AppCompatActivity {
TextView tvPackageName,tvTotalCost;
EditText edDetails;
Button btnAddToCart,btnBack;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);

        tvPackageName = findViewById(R.id.textViewLTPackageName);
        tvTotalCost = findViewById(R.id.textViewLTTotalCost);
        edDetails = findViewById(R.id.ListViewLT);
        btnAddToCart = findViewById(R.id.buttonLTGotocart);
        btnBack = findViewById(R.id.ButtonLTBack);

        edDetails.setKeyListener(null);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(labTestDetailActivity.this, LabTestActivity.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences SharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
               String username= SharedPreferences.getString("username","").toString();
               String product=tvPackageName.getText().toString();
               float price=Float.parseFloat(intent.getStringExtra("text3").toString());

               Database db= new Database(getApplicationContext(),"healthcare",null,1);

               if(db.checkcart(username,product)==1) {

                   Toast.makeText(getApplicationContext(), "product already added", Toast.LENGTH_SHORT).show();
               }
               else {
                   db.addcart(username,product,price,"lab");
                   Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(labTestDetailActivity.this,LabTestActivity.class));
                  }

               }


        });
    }
}