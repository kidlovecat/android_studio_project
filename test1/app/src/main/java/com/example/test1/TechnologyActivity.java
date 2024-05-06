package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.test1.model.Technology;
import com.example.test1.model.TechnologyAdapter;

public class TechnologyActivity extends AppCompatActivity {
    private ListView listView;
    TechnologyAdapter adapter;
    private Technology[] list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_technology);
        listView = findViewById(R.id.lv_tech);

        initData();

        adapter =  new TechnologyAdapter(this, list);
        listView.setAdapter(adapter);
    }

    private void initData() {
        Integer[] imgs = {R.drawable.android_logo,R.drawable.ios_logo};
        String[] names = {"android","ios"};
        String[] subs = {"Sub android", "Sub ios"};
        String[] dess = {"Des android", "Des ios"};

        list = new Technology[imgs.length];
        for(int i = 0; i < list.length; i++){
            list[i] = new Technology(imgs[i], names[i], subs[i], dess[i]);
        }
    }
}