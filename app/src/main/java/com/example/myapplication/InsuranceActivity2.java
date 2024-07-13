package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class InsuranceActivity2 extends AppCompatActivity {

    private String[][] insurance_details={

            {"Health Insurance Policies","","","","Click more Deatils"},
            {"Benifits of Insurance","","","","Click More Details"},
            {"Importance of Insurance","","","","Click More Details"},
            {"Insurance Plans","","","","Click More Details"},
            {"Health Insurance Coverage","","","","Click More Details"}

    };

    private int[] images={
            R.drawable.healthinsurance,
            R.drawable.benifits,
            R.drawable.importance,
            R.drawable.plans,
            R.drawable.coverage
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance2);
        ListView lst=findViewById(R.id.listViewIA);
        btnBack=findViewById(R.id.buttonIA);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InsuranceActivity2.this,homeActivity2.class));
            }
        });


        list = new ArrayList();
        for (int i = 0; i < insurance_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line 1", insurance_details[i][0]);
            item.put("line 2", insurance_details[i][1]);
            item.put("line 3", insurance_details[i][2]);
            item.put("line 4", insurance_details[i][3]);
            item.put("line 5", insurance_details[i][4]);
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[] {"line 1","line 2","line 3","line 4","line 5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it=new Intent(InsuranceActivity2.this, InsuranceArticlesDetailsActicity.class);
                it.putExtra("text1",insurance_details[i][0]);
                it.putExtra("text2",images[i]);
                startActivity(it);

            }
        });

    }
}