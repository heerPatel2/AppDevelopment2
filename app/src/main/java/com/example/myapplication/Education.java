package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.ItemAdapter;
import com.example.myapplication.Model.ItemList;

public class Education extends AppCompatActivity {

    RecyclerView recyclerView;

    ItemList[] mydata = new ItemList[]{
            new ItemList("DON BOSCO",R.drawable.don_bosco),
            new ItemList("BHS",R.drawable.bhs),
            new ItemList("DPS",R.drawable.dps),
            new ItemList("TREE HOUSE",R.drawable.tree_house),
            new ItemList("NALANDA",R.drawable.nalanda),
            new ItemList("ZENITH",R.drawable.zenith),
            new ItemList("BHAVANS",R.drawable.bhavans),
            new ItemList("AMICUS",R.drawable.amicus),

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        recyclerView = findViewById(R.id.recyclerView);
        ItemAdapter adapter = new ItemAdapter(mydata);
        recyclerView.setHasFixedSize(true);




   recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // For vertical and horizontal views
        LinearLayoutManager linear = new LinearLayoutManager(getApplicationContext());
        linear.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linear);

        //Grid layout view
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
//        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(gridLayoutManager);

        //Staggered Grid Layout
//        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,LinearLayoutManager.VERTICAL);
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.setAdapter(adapter);

    }
}