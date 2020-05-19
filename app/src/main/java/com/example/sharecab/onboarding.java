package com.example.sharecab;

import android.content.Intent;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class onboarding extends AppCompatActivity {

   ViewPager viewPager;
   pageadapter slide;

   TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_onboarding);
        skip = findViewById(R.id.skip);

          viewPager = findViewById(R.id.viewPager);
          slide = new pageadapter(onboarding.this);

          viewPager.setAdapter(slide);


          skip.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(new Intent(onboarding.this, login.class));
              }
          });

    }




}
