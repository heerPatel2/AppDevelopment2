package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class homeActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        SharedPreferences SharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username=SharedPreferences.getString("username","").toString();


        CardView exit=findViewById(R.id.cardExitCard);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor=SharedPreferences.edit();
                editor.clear();
                editor.apply();
                Toast.makeText(getApplicationContext(), "BACK", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(homeActivity2.this
                        ,homeActicity1.class));
            }
        });
CardView findDoctor=findViewById(R.id.cardFindDoctor);
findDoctor.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(homeActivity2.this
                ,FindDoctorActivity2.class));
    }
});

CardView labTest= findViewById(R.id.cardLabTest);
labTest.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(homeActivity2.this,LabTestActivity.class));
    }
});

CardView orderDetails=findViewById(R.id.cardOrderDetails);
orderDetails.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(homeActivity2.this,OrderDetailsMainActivity2.class));
    }
});


        CardView BuyMedicine=findViewById(R.id.cardBuyMedicine);
        BuyMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity2.this,BuyMedicineActivity2.class));
            }
        });

CardView health=findViewById(R.id.cardHealthDoctor);
health.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(homeActivity2.this,HealthArticlesActicity.class));
    }
});

        CardView hospital=findViewById(R.id.Hospital);
        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity2.this,Hospital_Acticity.class));
            }
        });


        CardView insurance=findViewById(R.id.Insurance);
        insurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity2.this, InsuranceActivity2.class));
            }
        });



    }
}