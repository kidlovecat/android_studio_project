package com.example.quanlibaihat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quanlibaihat.R;
//import com.example.quanlichitieu.adapter.RecycleViewAdapter;
//import com.example.quanlichitieu.dal.SQLiteHelper;

public class FragmentCaSi extends Fragment  {
//    private  RecycleViewAdapter adapter;
//
//    private RecyclerView recyclerView;
//    private SQLiteHelper db;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_casi,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        recyclerView = view.findViewById(R.id.recycleView);
//        adapter = new RecycleViewAdapter();
//        db = new SQLiteHelper(getContext());
////
////
//
//        List<Item> ls = db.getAll();
//        adapter.setList(ls);
////
//        LinearLayoutManager manager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);
//        recyclerView.setLayoutManager(manager);
//
//        recyclerView.setAdapter(adapter);
//        adapter.setItemListener(this);

    }

//    @Override
//    public void onItemClick(View v, int pos) {
//        Item item = adapter.getItem(pos);
//        Intent intent = new Intent(getActivity(), UpdateActivity.class);
//        intent.putExtra("item",item);
//        startActivity(intent);
//    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        List<Item> ls = db.getAll();
//        adapter.setList(ls);
//    }
}
