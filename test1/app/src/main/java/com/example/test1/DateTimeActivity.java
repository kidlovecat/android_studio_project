package com.example.test1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et, ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        et=findViewById(R.id.eTime);
        ed=findViewById(R.id.eDate);

        et.setOnClickListener(this);
        ed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Calendar c = Calendar.getInstance();
        int hh = c.get(Calendar.HOUR_OF_DAY);
        int mm = c.get(Calendar.MINUTE);
        int y = c.get(Calendar.YEAR);
        int mo = c.get(Calendar.MONTH);
        int da = c.get(Calendar.DAY_OF_MONTH);
        if(v == et){
            TimePickerDialog timedialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int h, int m) {
                    et.setText(h+":"+m);
                }
            },hh,mm,false);
            timedialog.show();
        }
        if(v == ed){
            DatePickerDialog datedialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    ed.setText(year+"/"+(month+1)+"/"+dayOfMonth);
                }
            },y,mo,da);
            datedialog.show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mFile){
            Toast.makeText(this,"File", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId()==R.id.mExit) {
            System.exit(0);
        } else if (item.getItemId()==R.id.mPhone) {
            Toast.makeText(this,"Phone", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,"Mail", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
    }
}