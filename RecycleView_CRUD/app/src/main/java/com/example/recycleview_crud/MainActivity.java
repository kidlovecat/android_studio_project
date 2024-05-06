package com.example.recycleview_crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.recycleview_crud.model.Cat;
import com.example.recycleview_crud.model.CatAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CatAdapter.CatItemListener,SearchView.OnQueryTextListener {
    private RecyclerView recyclerView;
    private CatAdapter adapter;
    private EditText eName, eDes, ePrice;
    private Button btAdd, btUpdate;
    private Spinner sp;
    private SearchView searchView;

    private int current;
    private int[] imgs= {R.drawable.img,R.drawable.img_1,R.drawable.img_2,
            R.drawable.img_3,R.drawable.img_4,R.drawable.img_5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        adapter = new CatAdapter(this);
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);

        searchView.setOnQueryTextListener(this);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat cat = new Cat();
                String i = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String des = eDes.getText().toString();
                String p = ePrice.getText().toString();

                int img = R.drawable.img;
                double price = 0;
                try{
                    img = imgs[Integer.parseInt(i)];
                    price = Double.parseDouble(p);
                }catch (NumberFormatException e){

                }
//                Toast.makeText(MainActivity.this, , Toast.LENGTH_SHORT).show();
                cat.setImg(img);
                cat.setName(name);
                cat.setDescribe(des);
                cat.setPrice(price);
//                Toast.makeText(MainActivity.this, cat.getName()+","+cat.getDescribe(), Toast.LENGTH_SHORT).show();
                adapter.add(cat);
            }
        });

        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cat cat = new Cat();
                String i = sp.getSelectedItem().toString();
                String name = eName.getText().toString();
                String des = eDes.getText().toString();
                String p = ePrice.getText().toString();

                int img = R.drawable.img;
                double price = 0;
                try{
                    img = imgs[Integer.parseInt(i)];
                    price = Double.parseDouble(p);
                }catch (NumberFormatException e){

                }
//                Toast.makeText(MainActivity.this, , Toast.LENGTH_SHORT).show();
                cat.setImg(img);
                cat.setName(name);
                cat.setDescribe(des);
                cat.setPrice(price);
                Toast.makeText(MainActivity.this, cat.getName()+","+cat.getDescribe(), Toast.LENGTH_SHORT).show();
                adapter.update(current,cat);

                btAdd.setEnabled(true);
                btUpdate.setEnabled(false);
            }
        });
    }

    private void initView() {
        sp = findViewById(R.id.img);
        SpinnerAdapter adapter = new com.example.recycleview_crud.model.SpinnerAdapter(this);
        sp.setAdapter(adapter);

        recyclerView = findViewById(R.id.recycleView);
        eName = findViewById(R.id.name);
        eDes = findViewById(R.id.des);
        ePrice = findViewById(R.id.price);

        btAdd = findViewById(R.id.btAdd);
        btUpdate = findViewById(R.id.btUpdate);
        btUpdate.setEnabled(false);

        searchView = findViewById(R.id.search);

    }

    @Override
    public void onItemClick(View v, int position) {
        btUpdate.setEnabled(true);
        btAdd.setEnabled(false);
        current = position;
        Cat cat = adapter.getItem(position);

        int img = cat.getImg();
        int p = 0;
        for(int i = 0; i < imgs.length; i++){
            if(img == imgs[i]){
                p = i;
                break;
            }
        }
        sp.setSelection(p);
        eName.setText(cat.getName());
        eDes.setText(cat.getDescribe());
        ePrice.setText(cat.getPrice()+"");
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        filter(s);
        return false;
    }
    private void filter(String s){
        List<Cat> filterlist = new ArrayList<>();
        for(Cat i : adapter.getBackUp()){
            if(i.getName().toLowerCase().contains(s.toLowerCase())){
                filterlist.add(i);
            }
        }
        if(filterlist.isEmpty()){
//            Toast.makeText(this, "No data found",Toast.LENGTH_SHORT).show();
        }else {
            adapter.filterList(filterlist);
        }
    }
}