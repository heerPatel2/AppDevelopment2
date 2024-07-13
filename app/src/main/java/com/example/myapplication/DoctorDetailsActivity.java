package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details=
            {
                    {"Doctor: Ajit Patel", "Hospital Address: Gotri Bharuch", "Exp: 5yrs", "Mobile: 9898987331", "600"},
                    {"Doctor: Prashad Pawar", "Hospital Address: Kalali Valsad", "Exp: 15yrs", "Mobile: 9898987332", "900"},
                    {"Doctor: Swapnil Shah", "Hospital Address: Tarsali Pune", "Exp: 8yrs", "Mobile: 9898987334", "300"},
                    {"Doctor: Dipak Deskmuk", "Hospital Address: Manjalpur Vadodara", "Exp: 5yrs", "Mobile: 9898987361", "500"},
                    {"Doctor: Ashok Pandey", "Hospital Address: Vasna Katraj", "Exp: 7yrs", "Mobile: 9893987331", "800"}
            };

    private String[][] doctor_details2=
            {
                    {"Doctor: Vakhat Parmar", "Hospital Address: Manjalpur Vadodara", "Exp: 5yrs", "Mobile: 9898987331", "600"},
                    {"Doctor: Hemlata Patel", "Hospital Address: Kalali Vadodara", "Exp: 15yrs", "Mobile: 9878987332", "900"},
                    {"Doctor: Sonali Agrawal", "Hospital Address: Akota Vadodara", "Exp: 8yrs", "Mobile: 9892347334", "300"},
                    {"Doctor: Nitin Agrawal", "Hospital Address: Tarsali Vadodara", "Exp: 5yrs", "Mobile: 9899987361", "500"},
                    {"Doctor: Ashok Pandey", "Hospital Address: Gorwa Vadodara", "Exp: 7yrs", "Mobile: 9845987331", "800"}
            };

    private String[][] doctor_details3=
            {
                    {"Doctor: Vakhat Parmar", "Hospital Address: Gotri Vadodara", "Exp: 5yrs", "Mobile: 9898987331", "600"},
                    {"Doctor: Prashad Pawar", "Hospital Address: Waghodia Vadodara", "Exp: 15yrs", "Mobile: 9898987332", "900"},
                    {"Doctor: Swapnil Kale", "Hospital Address: Bhayli Vadodara", "Exp: 8yrs", "Mobile: 9898987334", "300"},
                    {"Doctor: Dipak Deskmuk", "Hospital Address: Gorwa Vadodara", "Exp: 5yrs", "Mobile: 9898987361", "500"},
                    {"Doctor: Ashok Pandey", "Hospital Address: Mandvi Surat", "Exp: 7yrs", "Mobile: 9893987331", "800"}
            };

    private String[][] doctor_details4=
            {
                    {"Doctor: Vakhat Parmar", "Hospital Address: Gotri Vadodara", "Exp: 5yrs", "Mobile: 9898987331", "600"},
                    {"Doctor: Prashad Pawar", "Hospital Address: Gotri Bharuch", "Exp: 15yrs", "Mobile: 9898987332", "900"},
                    {"Doctor: Swapnil Kale", "Hospital Address: Maninagar Pune", "Exp: 8yrs", "Mobile: 9898987334", "300"},
                    {"Doctor: Dipak Deskmuk", "Hospital Address: Gorwa Bharuch", "Exp: 5yrs", "Mobile: 9898987361", "500"},
                    {"Doctor: Ashok Pandey", "Hospital Address: Susen Katraj", "Exp: 7yrs", "Mobile: 9893987331", "800"}
            };

    private String[][] doctor_details5=
            {
                    {"Doctor: Vakhat Parmar", "Hospital Address: Dahod Godhra", "Exp: 5yrs", "Mobile: 9898987331", "600"},
                    {"Doctor: Prashad Pawar", "Hospital Address: Maninagar Ahemdabad", "Exp: 15yrs", "Mobile: 9898987332", "900"},
                    {"Doctor: Swapnil Kale", "Hospital Address: Varasya Pune", "Exp: 8yrs", "Mobile: 9898987334", "300"},
                    {"Doctor: Dipak Deskmuk", "Hospital Address: Gorwa Bharuch", "Exp: 5yrs", "Mobile: 9898987361", "500"},
                    {"Doctor: Ashok Pandey", "Hospital Address: Ajwa Katraj", "Exp: 7yrs", "Mobile: 9893987331", "800"}
            };
TextView tv;
Button btn;
String[][] Doctor_details={};
HashMap<String,String> item;
ArrayList List;
SimpleAdapter sa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=findViewById(R.id.textViewBMTitle);
        btn=findViewById((R.id.buttonBMDGotocart));

        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);


        if(title.compareTo("Family Physician")==0)
            doctor_details=doctor_details;
        else

        if(title.compareTo("Dietician")==0)
            doctor_details=doctor_details2;
        else

        if(title.compareTo("Dentist")==0)
            doctor_details=doctor_details3;
        else

        if(title.compareTo("Surgeon")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"BACK",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity2.class));
            }
        });

        List=new ArrayList();
        for(int i=0;i<doctor_details.length;i++){
            item=new HashMap<String,String>();
            item.put("line1",doctor_details[i][0]);
            item.put("line2",doctor_details[i][1]);
            item.put("line3",doctor_details[i][2]);
            item.put("line4",doctor_details[i][3]);
            item.put("line5","Cons Fees:"+doctor_details[i][4]+"/-");
            List.add(item);
        }
sa=new SimpleAdapter(this,List,
        R.layout.multi_lines,
        new String[]{"line1","line2","line3","line4","line5"},
        new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});

        ListView lst=findViewById(R.id.ListViewLT);
        lst.setAdapter(sa);

lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Intent it=new Intent(DoctorDetailsActivity.this,BookAppointmentActivity2.class);
        it.putExtra("text1",title);
        it.putExtra("text2",doctor_details[i][0]);
        it.putExtra("text3",doctor_details[i][1]);
        it.putExtra("text4",doctor_details[i][3]);
        it.putExtra("text5",doctor_details[i][4]);
        startActivity(it);
    }
});
    }
}
