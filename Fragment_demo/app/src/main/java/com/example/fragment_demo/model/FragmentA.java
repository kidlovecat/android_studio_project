package com.example.fragment_demo.model;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragment_demo.R;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
        EditText tname = view.findViewById(R.id.tName);
        Button bt = view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = tname.getText().toString();
                tname.setText("Hello"+name);
                tname.setBackgroundColor(Color.BLUE);
            }
        });
        tname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tname.setText("");
                tname.setBackgroundColor(Color.TRANSPARENT);
            }
        });
    }
}
