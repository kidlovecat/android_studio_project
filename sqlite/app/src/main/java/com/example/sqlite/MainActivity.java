package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sqlite.database.BanHang;
import com.example.sqlite.model.Category;
import com.example.sqlite.model.Item;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private  Spinner sp;
    private TextView txt;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.sp);
        txt = findViewById(R.id.txt);
        bt = findViewById(R.id.bt);

        BanHang db = new BanHang(this);
//        db.insertCate(new Category("Sua"));
//        db.insertCate(new Category("Banh"));
//        db.insertCate(new Category("Keo"));

        List<Category> list = db.getCates();
        String[] a = new String[list.size()];
        for (int i = 0; i <list.size(); i++){
            a[i] = list.get(i).getId()+"-"+list.get(i).getName();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.items,a);
        sp.setAdapter(adapter);

        db.insertItem(new Item("Sua ong tho", 120, "10/09/2023", new Category(1,"")));
        db.insertItem(new Item("Keo dua", 20, "10/10/2022", new Category(2,"")));
        db.insertItem(new Item("Banh bong lan", 10, "10/03/2024", new Category(3,"")));
        //
        List<Item> list2 = db.getItems();


    }
}