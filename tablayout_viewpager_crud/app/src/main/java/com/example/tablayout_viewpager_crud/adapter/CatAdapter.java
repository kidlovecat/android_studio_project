package com.example.tablayout_viewpager_crud.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tablayout_viewpager_crud.MainActivity;
import com.example.tablayout_viewpager_crud.R;
import com.example.tablayout_viewpager_crud.model.Cat;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder>{
    private List<Cat> mList;
    private CatItemListener itemListener;

    private MainActivity mainActivity;

    public CatAdapter(MainActivity mainActivity){
        this.mainActivity = mainActivity;
        mList = new ArrayList<>();
    }

    public void setItemListener(CatItemListener itemListener){
        this.itemListener = itemListener;
    }

    public Cat getItem(int pos){
        return mList.get(pos);
    }
    public List<Cat> getListCat(){
        return mList;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mList.get(position);
        holder.img.setImageResource(cat.getImg());
        holder.name.setText(cat.getName());
        holder.price.setText(cat.getPrice()+"");
        holder.des.setText(cat.getDes());

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setTitle("Ban co chac muon xoa "+cat.getName());
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        mList.remove(position);
                        notifyDataSetChanged();
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
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView img;
        TextView name,price,des;
        Button btRemove;
        public CatViewHolder(@NonNull View View) {
            super(View);
            img = View.findViewById(R.id.item_img);
            name = View.findViewById(R.id.item_name);
            price = View.findViewById(R.id.item_price);
            des = View.findViewById(R.id.item_des);
            btRemove = View.findViewById(R.id.item_btRemove);
            btRemove.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(itemListener != null){
                itemListener.onItemClick(v,getAdapterPosition());
            }
        }
    }

    public interface CatItemListener {
        void onItemClick(View v, int pos);
    }
    public void add(Cat cat){
        mList.add(cat);
        notifyDataSetChanged();
    }
    public void update(int pos,Cat cat){
        mList.set(pos,cat);
        notifyDataSetChanged();
    }
}
