package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.android.material.navigation.NavigationView;

public class homeActicity1 extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_acticity1);

        drawerLayout = findViewById(R.id.drawable);
        navigationView = findViewById(R.id.navigationview);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_open, R.string.navigation_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();


        CardView ser1 = findViewById(R.id.service1);
        ser1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActicity1.this, homeActivity2.class));
            }
        });

        CardView ser2 = findViewById(R.id.service2);
        ser2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActicity1.this, HousingActivity.class));
            }
        });
        CardView ser3 = findViewById(R.id.service3);
        ser3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActicity1.this, Education.class));
            }
        });
    }


    @Override public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.sidemenu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.login) {
            Toast.makeText(this, "Logged In", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.logout) {
            startActivity(new Intent(homeActicity1.this, loginActivity2.class));
            Toast.makeText(this, "LOGOUT", Toast.LENGTH_SHORT).show();
        }else if(itemId== R.id.home_menu){
            startActivity(new Intent(homeActicity1.this, homeActicity1.class));
        }else if(itemId == R.id.share){
            try {
                Intent i=new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_SUBJECT,"Diploma");
                i.putExtra(Intent.EXTRA_TEXT,"https:play.google.com/store/apps/details?id"+getApplicationContext().getPackageName());
                startActivity(Intent.createChooser(i,"share with"));
            }catch(Exception e){
                Toast.makeText(this, "Unable to share this app", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }
}