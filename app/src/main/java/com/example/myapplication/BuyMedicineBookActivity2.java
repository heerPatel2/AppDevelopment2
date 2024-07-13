package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BuyMedicineBookActivity2 extends AppCompatActivity {
    EditText edname,edAddress,edcontact,edpincode;
    Button btnBooking,btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book2);

        edname=findViewById(R.id.editTextBMBFullName);
        edAddress=findViewById(R.id.editTextBMBAppAddress);
        edcontact=findViewById(R.id.editTextBMBAppContact);
        edpincode=findViewById(R.id.editTextBMBPinCode);
        btnBooking=findViewById(R.id.ButtonBMB);
        btnback=findViewById(R.id.buttonBackBM);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Back",Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBookActivity2.this, CartBuyMedicineActivity2.class));
            }
        });

        Intent intent=getIntent();
        String[] price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");


        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences SharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = SharedPreferences.getString("username", "").toString();

                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                db.addOrder(username,edname .getText().toString(),edAddress.getText().toString(),edcontact.getText().toString(),Integer.parseInt(edpincode.getText().toString()),date.toString(),"",Float.parseFloat(price[1].toString()),"medicine");
                db.removecart(username,"medicine");

              if(TextUtils.isEmpty(edname.getText().toString())){
              edname.setError("username is compulsory");
               return;
               }
                if(TextUtils.isEmpty(edAddress.getText().toString())){
                    edAddress.setError("Address is compulsory");
                    return;
                }
                if(TextUtils.isEmpty(edcontact.getText().toString())){
                    edcontact.setError("Contact is compulsory");
                    return;
                }
                if(TextUtils.isEmpty(edpincode.getText().toString())){
                    edpincode.setError("pincode is compulsory");
                    return;
                }

                Toast.makeText(getApplicationContext(),"Your Booking is done Successfully",Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicineBookActivity2.this,homeActivity2.class));

            }
        });
        }
}