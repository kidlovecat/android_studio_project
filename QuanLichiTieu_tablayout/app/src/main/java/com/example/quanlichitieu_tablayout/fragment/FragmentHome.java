package com.example.quanlichitieu_tablayout.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlichitieu_tablayout.R;
import com.example.quanlichitieu_tablayout.UpdateActivity;
import com.example.quanlichitieu_tablayout.adapter.RecycleViewAdapter;
import com.example.quanlichitieu_tablayout.dal.SQLiteHelper;
import com.example.quanlichitieu_tablayout.model.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FragmentHome extends Fragment implements RecycleViewAdapter.ItemListener {
    RecycleViewAdapter adapter;
    RecyclerView recyclerView;
    private SQLiteHelper db;
    private TextView tvTong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycleView);
        tvTong = view.findViewById(R.id.tvTong);

        adapter = new RecycleViewAdapter();
        db = new SQLiteHelper(getContext());

        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        List<Item> list = db.getByDate(f.format(d));


        adapter.setList(list);
        tvTong.setText("Tong tien: "+tong(list));
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        adapter.setItemListener(this);
    }

    private int tong(List<Item> ls){
        int t = 0;
        for(Item i: ls){
            t+=Integer.parseInt(i.getPrice());
        }
        return t;
    }

    @Override
    public void onItemClick(View v, int pos) {
        Item item= adapter.getItem(pos);
        Intent intent = new Intent(getActivity(), UpdateActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        Date d = new Date();
        SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        List<Item> list = db.getByDate(f.format(d));
        adapter.setList(list);
        tvTong.setText("Tong tien: "+tong(list));
    }
}
