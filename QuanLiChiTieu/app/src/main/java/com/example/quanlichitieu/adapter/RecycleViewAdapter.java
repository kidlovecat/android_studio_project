package com.example.quanlichitieu.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlichitieu.R;
import com.example.quanlichitieu.model.BaiHat;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.HomeViewHolder> {
    private List<BaiHat> list;
    private  ItemListener itemListener;
    public RecycleViewAdapter() {
        list = new ArrayList<>();
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public void setList(List<BaiHat> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public  BaiHat getItem(int pos){
        return list.get(pos);
    }
    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        BaiHat item = list.get(position);
//        holder.tv.setText(item.getTitl());
//        holder.category.setText(item.getCategory());
//        holder.price.setText(item.getPrice());
//        holder.date.setText(item.getDate());
        holder.ten.setText(item.getTen());
        holder.theloai.setText(item.getTheLoai());
        holder.yeuthich.setText(item.getYeuThich()+"");
        holder.album.setText(item.getAlbum());
        holder.casihat.setText(item.getCaSiHat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView ten, casihat;
        private TextView album, theloai;
        private TextView yeuthich;
        public HomeViewHolder(@NonNull View view) {
            super(view);
//            titl = view.findViewById(R.id.tvTitle);
//            category= view.findViewById(R.id.tvCategory);
//            price=view.findViewById(R.id.tvPrice);
//            date=view.findViewById(R.id.tvDate);
            ten = view.findViewById(R.id.tvTen);
            casihat = view.findViewById(R.id.tvCaSiHat);
            album = view.findViewById(R.id.tvAlbum);
            theloai = view.findViewById(R.id.tvTheLoai);
            yeuthich = view.findViewById(R.id.tvYeuThich);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemListener != null){
                itemListener.onItemClick(v,getAdapterPosition());
            }
        }
    }

    public interface ItemListener{
        void onItemClick(View v,int pos);

    }
}
