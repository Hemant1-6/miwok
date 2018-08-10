package com.example.hemant.miwok;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SimpleFragmentViewadapter viewadapter = new SimpleFragmentViewadapter(getSupportFragmentManager());
        viewPager.setAdapter(viewadapter);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

    }
}
