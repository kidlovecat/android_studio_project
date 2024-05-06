package com.example.quanlibaihat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener {
    private Spinner spAlbum, spTheLoai;
    private EditText eTen, eCaSi;
    private CheckBox yt;
    private Button btUpdate, btDelete, btCancel;

    private BaiHat baiHat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        initView();

        btUpdate.setOnClickListener(this);
        btDelete.setOnClickListener(this);
        btCancel.setOnClickListener(this);


        Intent intent = getIntent();
        baiHat = (BaiHat) intent.getSerializableExtra("baihat");
        eTen.setText(baiHat.getTen());
        eCaSi.setText(baiHat.getCaSiHat());

        int p = 0;
        for(int i = 0 ; i< spAlbum.getCount();i++){
            if(spAlbum.getItemAtPosition(i).toString().equalsIgnoreCase(baiHat.getAlbum())){
                p=i;
                break;
            }
        }
        spAlbum.setSelection(p);

        p = 0;
        for(int i = 0 ; i< spTheLoai.getCount();i++){
            if(spTheLoai.getItemAtPosition(i).toString().equalsIgnoreCase(baiHat.getTheLoai())){
                p=i;
                break;
            }
        }
        spTheLoai.setSelection(p);

        if(baiHat.getYeuThich() == 1){
            yt.setChecked(true);
        }else{
            yt.setChecked(false);
        }
    }
    private void initView(){
        spAlbum = findViewById(R.id.spAlbum);
        spTheLoai = findViewById(R.id.spTheLoai);
        eTen = findViewById(R.id.tvTen);
        eCaSi = findViewById(R.id.tvCaSiHat);
        yt = findViewById(R.id.cbYeuThich);
        btUpdate = findViewById(R.id.btUpdate);
        btDelete = findViewById(R.id.btDelete);
        btCancel = findViewById(R.id.btCancel);
        spAlbum.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,getResources().getStringArray(R.array.album)));
        spTheLoai.setAdapter(new ArrayAdapter<String>(this, R.layout.item_spinner,getResources().getStringArray(R.array.theloai)));
    }

    @Override
    public void onClick(View v) {
        SQLiteHelper db = new SQLiteHelper(this);

        if (v == btCancel) {
            finish();
        }
        if (v == btUpdate) {
            String t = eTen.getText().toString();
            String casi = eCaSi.getText().toString();
            String theloai = spTheLoai.getSelectedItem().toString();
            String album = spAlbum.getSelectedItem().toString();
            int yeuthich = 0;
            if(yt.isChecked()){
                yeuthich =1;
            }
            if(!t.isEmpty() && !casi.isEmpty() ) {
                db = new SQLiteHelper(this);
                db.updateBaiHat(new BaiHat(baiHat.getId(),t, casi, album, theloai, yeuthich));

                Toast.makeText(getApplicationContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();

                finish();
            }
        }
        if (v == btDelete) {
            int id = baiHat.getId();
            AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
            builder.setTitle("Thong bao xoa");
            builder.setMessage("Ban co chac muon xoa " + baiHat.getTen() + " khong?");
            builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SQLiteHelper bb = new SQLiteHelper(getApplicationContext());
                    bb.deleteBaiHat(id);
                    finish();
                }
            });
            builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }



    }
}