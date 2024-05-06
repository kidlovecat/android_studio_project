package com.example.recycleview_crud.model;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_crud.MainActivity;
import com.example.recycleview_crud.R;

import java.util.ArrayList;
import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {
    private Context context;
    private List<Cat> mList;
    private List<Cat> listBackUp;
    private CatItemListener mCatItem;

    public void setClickListener(CatItemListener mCatItem){
        this.mCatItem = mCatItem;
    }

    public CatAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
        listBackUp = new ArrayList<>();
    }

    public List<Cat> getBackUp(){
        return listBackUp;
    }
    public List<Cat> setmList(){
        return listBackUp;
    }
    public Cat getItem(int position){
        return mList.get(position);
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        Cat cat = mList.get(position);
        if (cat==null) return;
        holder.img.setImageResource(cat.getImg());
        holder.tvName.setText(cat.getName());
        holder.tvDes.setText(cat.getDescribe());
        holder.tvPrice.setText(cat.getPrice()+"");

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban co chac chan muon xoa "+cat.getName());
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        listBackUp.remove(position);
                        mList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }
    public void filterList(List<Cat> filterlist){
        mList = filterlist;
        notifyDataSetChanged();
    }
    public void add(Cat c){
        listBackUp.add(c);
        mList.add(c);
//        Toast.makeText(context, c.getName(), Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
    }

    public void update(int position,Cat cat){
        listBackUp.set(position,cat);
        mList.set(position,cat);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mList!=null) return mList.size();
        return 0;
    }

    public class CatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tvName, tvDes, tvPrice;
        private Button btRemove;

        public CatViewHolder(@NonNull View itemView){
            super(itemView);
            img = itemView.findViewById(R.id.img);
            tvName = itemView.findViewById(R.id.txtName);
            tvDes = itemView.findViewById(R.id.txtDes);
            tvPrice = itemView.findViewById(R.id.txtPrice);
            btRemove = itemView.findViewById(R.id.btRemove);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mCatItem!=null){
                mCatItem.onItemClick(v,getAdapterPosition());
            }
        }
    }

    public interface CatItemListener{
        void onItemClick(View v, int position);
    }

}
