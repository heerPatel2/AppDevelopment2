package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HousingActivity extends AppCompatActivity {

    CardView foodCard;
    CardView waterCard;
    CardView moversCard;
    CardView rentCard;
    CardView buyCard;
    CardView communityCard;
    CardView electricianCard;
    CardView painterCard;
    CardView carpenterCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_housing);

        foodCard = findViewById(R.id.food_supplier);
        foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this,Food_Activity.class);
                startActivity(intent);
            }
        });

        waterCard = findViewById(R.id.water_supplier);
        waterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this, Restaurant_Activity.class);
                startActivity(intent);
            }
        });

        moversCard = findViewById(R.id.packer_movers);
        moversCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this,Movers_Activity.class);
                startActivity(intent);
            }
        });

        rentCard = findViewById(R.id.house_renting);
        rentCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this,Rent_Activity.class);
                startActivity(intent);
            }
        });

        buyCard = findViewById(R.id.house_purchase);
        buyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this,Buy_Activity.class);
                startActivity(intent);
            }
        });

        communityCard = findViewById(R.id.nearest_community);
        communityCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this,Community_Activity.class);
                startActivity(intent);
            }
        });

        electricianCard = findViewById(R.id.house_electrician);
        electricianCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this,Electrician_Activity.class);
                startActivity(intent);
            }
        });

        painterCard = findViewById(R.id.house_painter);
        painterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this,Painter_Activity.class);
                startActivity(intent);
            }
        });

        carpenterCard = findViewById(R.id.house_carpenter);
        carpenterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HousingActivity.this,Carpenter_Activity.class);
                startActivity(intent);
            }
        });


    }
}