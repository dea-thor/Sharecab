package com.example.sharecab;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.sharecab.Fragments.Requests;
import com.example.sharecab.Fragments.YourRequest;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {


    TabLayout tabLayout ;
    ViewPager viewPager ;
    ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager());
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle mToggle;
    MenuItem addNote;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        addNote = findViewById(R.id.addnote);

        viewPageAdapter.addFragment(new Requests(), "Requests");
        viewPageAdapter.addFragment(new YourRequest(),"Your Request");
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mToggle.onOptionsItemSelected(item))
            return true;
        if(item.getItemId() == R.id.addnote)
        {
            startActivity(new Intent(HomePage.this, input.class));
        }




        return super.onOptionsItemSelected(item);
    }

    class ViewPageAdapter extends FragmentPagerAdapter {


        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        private ViewPageAdapter(FragmentManager fm) {
            super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            this.titles = new ArrayList<>();
            this.fragments = new ArrayList<>();
        }

        @Override
        public Fragment getItem(int i) {

            return  fragments.get(i);

        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        private   void addFragment(Fragment fragment, String title)
        {
            fragments.add(fragment);
            titles.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

    //Creating add note button in the action bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.addnote, menu);

        return super.onCreateOptionsMenu(menu);


    }






}
