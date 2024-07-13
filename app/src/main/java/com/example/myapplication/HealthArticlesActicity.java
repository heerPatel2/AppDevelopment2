package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthArticlesActicity extends AppCompatActivity {

    private String[][] health_details={

            {"Walking DAILY","","","","Click more Deatils"},
            {"Home Care of Covid-19","","","","Click More Details"},
            {"Stop Smoking","","","","Click More Details"},
            {"Health Gut","","","","Click More Details"},
            {"Health and Fitness","","","","Click More Details"},
            {"Eat Better Plate","","","","Click More Details"}

    };

    private int[] images={
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health5,
            R.drawable.health6,
            R.drawable.health7
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles_acticity);
        ListView lst=findViewById(R.id.listViewHA);
btnBack=findViewById(R.id.buttonHA);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthArticlesActicity.this,homeActivity2.class));
            }
        });


        list = new ArrayList();
        for (int i = 0; i < health_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line 1", health_details[i][0]);
            item.put("line 2", health_details[i][1]);
            item.put("line 3", health_details[i][2]);
            item.put("line 4", health_details[i][3]);
            item.put("line 5", health_details[i][4]);
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[] {"line 1","line 2","line 3","line 4","line 5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst.setAdapter(sa);


   lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
       @Override
       public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
           Intent it=new Intent(HealthArticlesActicity.this,HealthArticlesDetailsActicity.class);
           it.putExtra("text1",health_details[i][0]);
           it.putExtra("text2",images[i]);
           startActivity(it);

       }
   });

    }
}