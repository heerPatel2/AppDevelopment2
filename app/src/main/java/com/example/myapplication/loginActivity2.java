package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class loginActivity2 extends AppCompatActivity {
    EditText edUsername, edPassword;
    boolean passwordvisible;
    Button btn;
    TextView tv,tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        edUsername = findViewById(R.id.editTextLTBAppAddress);
        edPassword = findViewById(R.id.editTextLTBAppContact);
        btn = findViewById(R.id.buttonBookApp2);
        tv = findViewById(R.id.textView3);

        edPassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent Event) {
                final int Right=2;
                if(Event.getAction()==MotionEvent.ACTION_UP){
                    if(Event.getRawX()>=edPassword.getRight()-edPassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=edPassword.getSelectionEnd();
                        if (passwordvisible) {

                            edPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_off_24,0);
                            edPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible=false;
                        }
                        else{
                            edPassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_24,0);
                            edPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible=true ;
                        }
                        edPassword.setSelection(selection);
                        return true;
                    }
                }
return false;
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String password = edPassword.getText().toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (db.login(username, password) == 1) {
                        Toast.makeText(getApplicationContext(), "Welcome" + username + "!", Toast.LENGTH_SHORT).show();
                        SharedPreferences SharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = SharedPreferences.edit();
                        editor.putString("username", username);
                        editor.apply();
                        startActivity(new Intent(loginActivity2.this
                                , homeActicity1.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(loginActivity2.this
                        ,Registeractivity.class));
            }
        });


    }
}