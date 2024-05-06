package com.example.intent_startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intent_startactivityforresult.model.Account;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txt;
    private Button btLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogout = findViewById(R.id.btLogout);
        btLogout.setOnClickListener(this);
        txt = findViewById(R.id.txtInfo);
        Intent intent = getIntent();
        if(intent.getSerializableExtra("account") != null && intent.getSerializableExtra("user") != null){
            Account log = (Account) intent.getSerializableExtra("account");
            Account user = (Account) intent.getSerializableExtra("user");
            if(log.getUsername().equalsIgnoreCase(user.getUsername()) && log.getPass().equalsIgnoreCase(user.getPass()) ){
                txt.setText("Dang nhap thanh cong");
            }else{
                txt.setText("Tai khoan khong ton tai");
            }
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btLogout){
            Intent t = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(t);
        }
    }
}