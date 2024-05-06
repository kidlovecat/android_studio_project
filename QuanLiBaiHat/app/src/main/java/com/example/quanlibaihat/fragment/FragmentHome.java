package com.example.quanlibaihat.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlibaihat.R;
//import com.example.quanlibaihat.UpdateActivity;
import com.example.quanlibaihat.UpdateActivity;
import com.example.quanlibaihat.adapter.RecycleViewBaiHatAdapter;
import com.example.quanlibaihat.dal.SQLiteHelper;
import com.example.quanlibaihat.model.BaiHat;

import java.util.List;

public class FragmentHome extends Fragment implements RecycleViewBaiHatAdapter.ItemListener {
    RecycleViewBaiHatAdapter adapter;
    RecyclerView recyclerView;
    private SQLiteHelper db;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recycleView);

        adapter = new RecycleViewBaiHatAdapter();
        db = new SQLiteHelper(getContext());

        List<BaiHat> list = db.getAll();

        adapter.setList(list);

        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

        adapter.setItemListener(this);
    }


    @Override
    public void onItemClick(View v, int pos) {
        BaiHat baihat= adapter.getItem(pos);
        Intent intent = new Intent(getActivity(), UpdateActivity.class);
        intent.putExtra("baihat",  baihat);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        List<BaiHat> list = db.getAll();
        adapter.setList(list);
    }
}
