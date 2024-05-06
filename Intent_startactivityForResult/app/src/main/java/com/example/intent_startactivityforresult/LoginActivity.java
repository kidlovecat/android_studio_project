package com.example.intent_startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intent_startactivityforresult.model.Account;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvUsername, tvPass;
    private Button btLogin,btRegister;
    private  final static int REQUEST_CODE = 10000;

    private Account user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
    }
    private void initView(){
        tvUsername = findViewById(R.id.txtUsername);
        tvPass = findViewById(R.id.txtPassword);
        btLogin = findViewById(R.id.btLogin);
        btRegister = findViewById(R.id.btRegister);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btLogin){
            Intent loginIntent = new Intent(LoginActivity.this, MainActivity.class);
            Account account = new Account(tvUsername.getText().toString(),tvPass.getText().toString());
            loginIntent.putExtra("account",account);
            loginIntent.putExtra("user",user);
            startActivity(loginIntent);
        }
        else{
            Intent reIntent = new Intent(LoginActivity.this, RegisterActivity.class);
//            startActivity(reIntent, REQUEST_CODE);
            startActivityForResult(reIntent,REQUEST_CODE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if(data == null){
                Toast.makeText(this, "Nguoi dung huy dang ki", Toast.LENGTH_SHORT).show();
            }else{
                user = (Account) data.getSerializableExtra("data");
                tvUsername.setText(user.getUsername());
                tvPass.setText(user.getPass());
            }
        }
    }
}