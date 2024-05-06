package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private CheckBox cb1, cb2, cb3;
    private RatingBar rb1;
    private RadioButton gnam, gnu;
    private Spinner sp1, sp2;
    private TextView tv;
    private Button btht;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.some_widgets);
        initView();
        btht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ccb1="", ccb2="", ccb3="", gt="", kq;
                if(cb1.isChecked()) {
                    ccb1 = cb1.getText().toString();
                }
                if(cb2.isChecked()) {
                    ccb2 = cb2.getText().toString();
                }
                if(cb3.isChecked()) {
                    ccb3 = cb3.getText().toString();
                }
                if(gnam.isChecked()) {
                    gt = gnam.getText().toString();
                }else{
                    gt = gnu.getText().toString();
                }
                kq = ccb1+" "+ccb2+" "+ccb3+" "+ gt+" "+rb1.getRating()+" "+sp1.getSelectedItem()+" "+sp2.getSelectedItem();
                tv.setText(kq);
            }
        });
    }


    private void initView() {
        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        gnam = findViewById(R.id.gnam);
        gnu = findViewById(R.id.gnu);
        rb1 = findViewById(R.id.rb1);
        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        tv = findViewById(R.id.tv4);
        btht = findViewById(R.id.btht);
    }

//    public void show1(View v){
//        String ccb1="", ccb2="", ccb3="", gt="", kq;
//        if(cb1.isChecked()) {
//            ccb1 = cb1.getText().toString();
//        }
//        if(cb2.isChecked()) {
//            ccb2 = cb2.getText().toString();
//        }
//        if(cb3.isChecked()) {
//            ccb3 = cb3.getText().toString();
//        }
//        if(gnam.isChecked()) {
//            gt = gnam.getText().toString();
//        }else{
//            gt = gnu.getText().toString();
//        }
//        kq = ccb1+" "+ccb2+" "+ccb3+" "+ gt+" "+rb1.getRating()+" "+sp1.getSelectedItem()+" "+sp2.getSelectedItem();
//        tv.setText(kq);
//    }
}