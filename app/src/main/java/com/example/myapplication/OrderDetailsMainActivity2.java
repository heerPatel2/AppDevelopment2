package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderDetailsMainActivity2 extends AppCompatActivity {

    private String[][] order_details={};

    HashMap<String,String> item;
    ArrayList List;
    SimpleAdapter sa;
    ListView lst;
    Button  btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details_main2);

        btn = findViewById(R.id.buttonODChecking);
        lst=findViewById(R.id.listviewODMultiline);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OrderDetailsMainActivity2.this, homeActivity2.class));
            }
        });
     Database db = new Database(getApplicationContext(), "healthcare", null, 1);
        SharedPreferences SharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = SharedPreferences.getString("username", "").toString();
        ArrayList dbdata = db.getOrderdata(username);

        order_details = new String[dbdata.size()][];
        for (int i = 0; i < order_details.length; i++) {
            order_details[i] = new String[5];
            String arrdata = dbdata.get(i).toString();
            String[] strdata = arrdata.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0] = strdata[0];
            order_details[i][1] = strdata[1] + " " + strdata[3];
            if (strdata[7].compareTo("medicine") == 0) {
                order_details[i][3] = "Del:" + strdata[4];
            } else {
                order_details[i][3] = "Del:" + strdata[4] + " " + strdata[5];

            }
            order_details[i][2] = "Rs:" + strdata[6];
            order_details[i][4] = strdata[7];
        }

        List = new ArrayList();
        for (int i = 0; i < order_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line 1", order_details[i][0]);
            item.put("line 2", order_details[i][1]);
            item.put("line 3", order_details[i][2]);
            item.put("line 4", order_details[i][3]);
            item.put("line 5", order_details[i][4]);
            List.add(item);
        }

        sa=new SimpleAdapter(this,List,R.layout.multi_lines,
                new String[] {"line 1","line 2","line 3","line 4","line 5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst.setAdapter(sa);

    }
}