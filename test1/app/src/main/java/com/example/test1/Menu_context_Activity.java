package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Menu_context_Activity extends AppCompatActivity {
    private Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_menu);

        bt = findViewById(R.id.button_menu);
        registerForContextMenu(bt);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.color_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.mRed){
            bt.setTextColor(Color.RED);

        }
        if(item.getItemId() == R.id.mblue){
            bt.setTextColor(Color.BLUE);

        }
        if(item.getItemId() == R.id.mGreen){
            bt.setTextColor(Color.GREEN);

        }
        return super.onContextItemSelected(item);
    }
}