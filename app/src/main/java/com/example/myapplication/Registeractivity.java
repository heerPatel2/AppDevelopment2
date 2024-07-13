package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;



public class Registeractivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;
    boolean passwordvisible;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextLTBPinCode);
        edEmail = findViewById(R.id.editTextLTBAppAddress);

        edPassword = findViewById(R.id.editTextLTBAppContact);
        edConfirm = findViewById(R.id.editTextAppPassword2);
        btn = findViewById(R.id.buttonBookApp2);
        tv = findViewById(R.id.textView3);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registeractivity.this
                        , loginActivity2.class));
            }
        });


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


        edConfirm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent Event) {
                final int Right=2;
                if(Event.getAction()==MotionEvent.ACTION_UP){
                    if(Event.getRawX()>=edConfirm.getRight()-edConfirm.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=edConfirm.getSelectionEnd();
                        if (passwordvisible) {

                            edConfirm.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_off_24,0);
                            edConfirm.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordvisible=false;
                        }
                        else{
                            edConfirm.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.baseline_visibility_24,0);
                            edConfirm.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordvisible=true ;
                        }
                        edConfirm.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUsername.getText().toString();
                String Email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext(), "healthcare", null, 1);


                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirm) == 0) {
                        if (isValid(password)) {
                            db.register(username, Email, password);
                            Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Registeractivity.this
                                    , loginActivity2.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Password must contain at least  8 character,having letter,digit and special symbols", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Password and confirm Password did't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    public static boolean isValid(String password) {


            int f1 = 0, f2 = 0, f3 = 0;
            if (password.length() < 8) {
                return false;
            } else {
                for (int p = 0; p < password.length(); p++) {
                    if (Character.isLetter(password.charAt((p)))) {
                        f1 = 1;
                    }
                }
                for (int r = 0; r < password.length(); r++) {
                    if (Character.isDigit(password.charAt((r)))) {
                        f2 = 1;
                    }
                }
                for (int s = 0; s < password.length(); s++) {
                    char c = password.charAt(s);
                    if (c >= 33 && c <= 46 || c == 64) {
                        f3 = 1;
                    }
                }
                if (f1 == 1 && f2 == 1 && f3 == 1)
                    return true;
                return false;

            }


    }
}


