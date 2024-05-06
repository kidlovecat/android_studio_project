package com.example.test1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test1.R;

public class TechnologyAdapter extends ArrayAdapter<Technology> {
    private Context context;
    private Technology[] mlist;

    public TechnologyAdapter(@NonNull Context context,Technology[] mlist) {
        super(context, R.layout.item_tech,mlist);
        this.context = context;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_tech,null,true);

        ImageView img = view.findViewById(R.id.img_tech1);
        TextView tname = view.findViewById(R.id.tname1);
        TextView tsub = view.findViewById(R.id.tsub1);
        TextView tdes = view.findViewById(R.id.tdes1);

        Technology t = mlist[position];

        img.setImageResource(t.getImg());
        tname.setText(t.getName());
        tsub.setText(t.getSub());
        tdes.setText(t.getDes());

        return view;
    }

    public Technology getItem(int position){
        return mlist[position];
    }
}
