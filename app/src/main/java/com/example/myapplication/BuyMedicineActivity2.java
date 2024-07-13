package com.example.myapplication;

import android.annotation.SuppressLint;
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

public class BuyMedicineActivity2 extends AppCompatActivity {

    private String[][] packages=
            {
                    {"Uprise-D3 1000IU capsule","","","","50"},
                    {"healthVit Chromium Picolinate 200mg Capsule","","","","305"},
                    {"Vitamin B Complex Capsules","","","","448"},
                    {"Inlife Vitamin E Wheat Germ Oil Capsule","","","","539"},
                    {"Dolo 650 Tablet","","","","30"},
                    {"Crocin 650 Advance Tablet","","","","50"},
            };
    private String[] package_details={
            "Building and Keeping the bones & teeth strong\n"+
                    "Reducing Fatigue & muscular pain/n"+
                    "Boosting immunity and Increasing Resistence against infection",
                    "Helps in formation of Red Blood Cells\n"+
                    "Maintains healthy nervous system\n",
            "It promotes health as well as skin benefit.\n"+
                    "It helps reduce the skin blemish and pigmentation.\n",
            "Dolo 650 Tablet helps relieve pain and fever by blocking the release of certain  chemical messegenger responsible for fever and pain"+
                    "suitable for people with a heart condition or high blood presure"
    };
HashMap<String,String> item;
ArrayList list;
SimpleAdapter sa;
ListView lst;
Button btnBack,btnGotocart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine2);

        lst=findViewById(R.id.ListViewLT);
        btnBack=findViewById(R.id.buttonBMBack);
        btnGotocart=findViewById(R.id.buttonBMGotocart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicineActivity2.this,homeActivity2.class));
            }
        });

        btnGotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(BuyMedicineActivity2.this,CartBuyMedicineActivity2.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++){
            item = new HashMap<String, String>();
            item.put("line 1", packages[i][0]);
            item.put("line 2", packages[i][1]);
            item.put("line 3", packages[i][2]);
            item.put("line 4", packages[i][3]);
            item.put("line 5","Total Cost:" +packages[i][4]+"/-");
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[] {"line 1","line 2","line 3","line 4","line 5"},
                new int[] {R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        lst.setAdapter(sa);


        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                    Intent it=new Intent(BuyMedicineActivity2.this,BuyMedicineDetailsActivity2.class);
                    it.putExtra("text1",packages[i][0]);
                    it.putExtra("text2",package_details[i]);
                    it.putExtra("text3",packages[i][4]);
                    startActivity(it);
            }
        });

    }
}