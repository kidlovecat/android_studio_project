package com.example.quanlibaihat;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlibaihat.dal.SQLiteHelper;
import com.example.quanlibaihat.model.BaiHat;

public class AddActivity extends AppCompatActivity implements View.OnClickListener{
    private Spinner spAlbum, spTheLoai;
    private EditText eTen, eCaSi;
    private CheckBox yt;
    private Button btAdd, btCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();

        btAdd.setOnClickListener(this);
        btCancel.setOnClickListener(this);


    }
    private void initView(){
        spAlbum = findViewById(R.id.spAlbum);
        spTheLoai = findViewById(R.id.spTheLoai);
        eTen = findViewById(R.id.tvTen);
        eCaSi = findViewById(R.id.tvCaSiHat);
        yt = findViewById(R.id.cbYeuThich);
        btAdd = findViewById(R.id.btAdd);
        btCancel = findViewById(R.id.btCancel);
        spAlbum.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,getResources().getStringArray(R.array.album)));
        spTheLoai.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,getResources().getStringArray(R.array.theloai)));
    }

    @Override
    public void onClick(View v) {
        if(v == btCancel){
            finish();
        }else{
            String t = eTen.getText().toString();
            String casi = eCaSi.getText().toString();
            String theloai = spTheLoai.getSelectedItem().toString();
            String album = spAlbum.getSelectedItem().toString();
            int yeuthich = 0;
            if(yt.isChecked()){
                yeuthich =1;
            }
            if(!t.isEmpty() && !casi.isEmpty() ){

                if(!t.isEmpty() && !casi.isEmpty() ) {
                    SQLiteHelper db = new SQLiteHelper(this);
                    db.updateBaiHat(new BaiHat(t, casi, album, theloai, yeuthich));

                    Toast.makeText(getApplicationContext(), "Thêm thành công", Toast.LENGTH_SHORT).show();

                    finish();
                }
            }
        }
    }
}