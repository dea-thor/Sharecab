package com.example.sharecab;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class login extends AppCompatActivity {

    TextView signup;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        signup = findViewById(R.id.signUp);




    }

    public void signup(View view)
    {
        startActivity(new Intent(login.this,signup.class));

    }

    public void loginO(View view)
    {
        startActivity(new Intent(login.this,HomePage.class));

    }



}
