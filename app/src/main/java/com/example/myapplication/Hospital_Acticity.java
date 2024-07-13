package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter2.ItemAdapter2;
import com.example.myapplication.Model2.ItemList2;

public class Hospital_Acticity extends AppCompatActivity {
    RecyclerView recyclerView2;
    ItemList2[] mydataa = new ItemList2[]{
            new ItemList2("Zydus",R.drawable.zydus),
            new ItemList2("Welcare",R.drawable.welcare),
            new ItemList2("Gujarat",R.drawable.gujarat)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_acticity);
        recyclerView2 = findViewById(R.id.recyclerView2);
        ItemAdapter2 adapter2 = new ItemAdapter2(mydataa);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        recyclerView2.setAdapter(adapter2);
    }
}