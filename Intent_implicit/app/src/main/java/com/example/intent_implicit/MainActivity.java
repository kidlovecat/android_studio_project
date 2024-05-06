package com.example.intent_implicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btWeb, btSms, btPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btWeb = findViewById(R.id.web);
        btSms = findViewById(R.id.sms);
        btPhone = findViewById(R.id.phone);

        btWeb.setOnClickListener(this);
        btSms.setOnClickListener(this);
        btPhone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.web){
            Intent w = new Intent(Intent.ACTION_VIEW);
            w.setData(Uri.parse("https://www.google.com.vn/?hl=vi"));
            startActivity(w);
        }else if(v.getId() == R.id.sms){
            Intent m = new Intent(Intent.ACTION_VIEW);
            m.setData(Uri.parse(""+"0823226644"));
            m.putExtra("sms_body", "SMS");
            startActivity(m);
        }else{
            Intent m = new Intent(Intent.ACTION_VIEW);
            m.setData(Uri.parse("tel:0823226644"));
            startActivity(m);
        }
    }
}