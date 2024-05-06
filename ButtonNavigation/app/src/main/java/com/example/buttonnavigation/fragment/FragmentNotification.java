package com.example.buttonnavigation.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.buttonnavigation.R;
import com.example.buttonnavigation.adapter.MessageAdapter;
import com.example.buttonnavigation.model.Message;

import java.util.ArrayList;
import java.util.List;

public class FragmentNotification extends Fragment {
    MessageAdapter messageAdapter;
    RecyclerView recyclerView;
    List<Message> list;

    public FragmentNotification(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noti,container,false);
        list = new ArrayList<>();
        list.add(new Message(R.drawable.icon_cat,"Thanh", "Em an com chua", "16:30"));
        list.add(new Message(R.drawable.icon_cat,"Tu", "Em an com chua", "17:30"));
        list.add(new Message(R.drawable.icon_cat,"Tuan", "Em an com chua", "18:30"));
        list.add(new Message(R.drawable.icon_cat,"Tin", "Em an com chua", "19:30"));
        list.add(new Message(R.drawable.icon_cat,"Thanh", "Em an com chua", "20:30"));

        recyclerView = view.findViewById(R.id.recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(view.getContext(),RecyclerView.VERTICAL,false);
        messageAdapter = new MessageAdapter(view.getContext(),list);

        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(messageAdapter);


        return view;
    }
}
