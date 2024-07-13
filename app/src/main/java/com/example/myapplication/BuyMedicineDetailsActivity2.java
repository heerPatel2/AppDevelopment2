package com.example.myapplication;

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

public class BuyMedicineDetailsActivity2 extends AppCompatActivity {
    TextView tvPackageName,tvTotalCost;
    EditText edDetails;

    Button btnAddToCart,btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details2);


        tvPackageName = findViewById(R.id.textViewBMDPackageName);
        tvTotalCost = findViewById(R.id.textViewBMDTotalCost);
        edDetails = findViewById(R.id.edittextBMD);
        edDetails.setKeyListener(null);
        btnAddToCart = findViewById(R.id.buttonBMDGotocart);
        btnBack = findViewById(R.id.buttonBMDBack);

        Intent intent=getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : "+intent.getStringExtra("text3")+"/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineDetailsActivity2.this, BuyMedicineActivity2.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences SharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username= SharedPreferences.getString("username","").toString();
                String Product=tvPackageName.getText().toString();
                float price=Float.parseFloat(intent.getStringExtra("text3").toString());

                Database db= new Database(getApplicationContext(),"healthcare",null,1);
                if(db.checkcart(username,Product)==1) {

                    Toast.makeText(getApplicationContext(), "product already added", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.addcart(username,Product,price,"Medicine");
                    Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity2.this,BuyMedicineActivity2.class));
                }

            }


        });
    }
}
