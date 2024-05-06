package com.example.fragment_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragment_demo.model.FragmentA;
import com.example.fragment_demo.model.FragmentB;

public class DynamicFragment extends AppCompatActivity implements View.OnClickListener {
    Button bta, btb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dynamic);

        bta = findViewById(R.id.bta);
        btb = findViewById(R.id.btb);

        bta.setOnClickListener(this);
        btb.setOnClickListener(this);

    }
    public void onClick(View view){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fg;
        if(view.getId()==R.id.bta){
            fg = new FragmentA();
            transaction.add(R.id.frame,fg);

        }
        else {
            fg = new FragmentB();
            transaction.add(R.id.frame,fg);
        }
        transaction.commit();
    }
}