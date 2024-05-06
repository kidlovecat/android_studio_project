package com.example.buttonnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.buttonnavigation.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager viewPager;

    private FloatingActionButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        navigationView = findViewById(R.id.navigation);
        button = findViewById(R.id.fab);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "hi", Toast.LENGTH_SHORT).show();
            }
        });

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),4);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0: navigationView.getMenu().findItem(R.id.mHome).setCheckable(true);
                        break;
                    case 1: navigationView.getMenu().findItem(R.id.mNoti).setCheckable(true);
                        break;
                    case 2: navigationView.getMenu().findItem(R.id.mSearch).setCheckable(true);
                        break;
                    case 3: navigationView.getMenu().findItem(R.id.mCafe).setCheckable(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.mHome){
                    viewPager.setCurrentItem(0);
                }
                else if(item.getItemId() == R.id.mNoti){
                    viewPager.setCurrentItem(1);
                }
                else if(item.getItemId() == R.id.mSearch){
                    viewPager.setCurrentItem(2);
                }
                else{
                    viewPager.setCurrentItem(3);
                }
                return true;
            }
        });
    }
}