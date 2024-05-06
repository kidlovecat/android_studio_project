package com.example.intent_startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.intent_startactivityforresult.model.Account;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvUsername, tvPass;
    private Button btCancel,btRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();

        btCancel.setOnClickListener(this);
        btRegister.setOnClickListener(this);

    }
    private void initView(){
        tvUsername = findViewById(R.id.txtUsername);
        tvPass = findViewById(R.id.txtPassword);
        btCancel = findViewById(R.id.btCancel);
        btRegister = findViewById(R.id.btRegister);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btRegister){
            Account account = new Account(tvUsername.getText().toString(),tvPass.getText().toString());
            Intent intent = new Intent();
            intent.putExtra("data", account);
            setResult(RESULT_OK, intent);
            finish();
        }
        else{
            setResult(RESULT_CANCELED, null);
            finish();
        }
    }
}