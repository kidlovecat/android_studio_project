package com.example.test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CaculatorActivity extends AppCompatActivity {
    private TextView kq;
    private EditText edit1,edit2;
    private Button btAdd;
    private Spinner sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);
        initView();
    }

    private void initView() {
        kq = findViewById(R.id.kq);
        edit1 = findViewById(R.id.e1);
        edit2 = findViewById(R.id.e2);
        sp = findViewById(R.id.sp);
    }

    public void add(View v){
        String nn1 = edit1.getText().toString();
        String nn2 = edit2.getText().toString();
        double n1,n2;
        try {
            n1 = Double.parseDouble(nn1);
            n2 = Double.parseDouble(nn2);
            String p = sp.getSelectedItem().toString();
            String kk = tinhtoan(n1,n2,p);
            kq.setText(kk);
            Toast.makeText(this, kk, Toast.LENGTH_LONG).show();
        }catch (NumberFormatException e){

        }
    }
    private String tinhtoan(double x, double y, String p){
        String s = "";
        switch (p){
            case "+": s = "Tong:"+(x+y);
                break;
            case "-": s = "Hieu:"+(x-y);
                break;
            case "x": s = "Tich:"+(x*y);
                break;
            case ":":
                if(y == 0)
                    s="Khong chia cho 0";
                else
                    s = "Thuong:"+(x/y);
                break;
        }
        return s;
    }
}