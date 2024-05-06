package com.example.kiem_tra_1.model;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kiem_tra_1.R;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder> {
    private Context context;
    private List<Phone> mList;
    private List<Phone> listBackUp;
    private PhoneItemListener mPhoneItem;

    public void setClickListener(PhoneItemListener mPhoneItem){
        this.mPhoneItem = mPhoneItem;
    }

    public PhoneAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
        listBackUp = new ArrayList<>();
    }

    public List<Phone> getBackUp(){
        return listBackUp;
    }
    public List<Phone> setmList(){
        return listBackUp;
    }
    public Phone getItem(int position){
        return mList.get(position);
    }

    @NonNull
    @Override
    public PhoneViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new PhoneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhoneViewHolder holder, int position) {
        Phone phone = mList.get(position);
        if (phone==null) return;
        holder.img.setImageResource(phone.getImg());
        holder.tvName.setText(phone.getName());
        holder.tvDes.setText(phone.getXuatxu());
        holder.tvPrice.setText(phone.getPrice()+"");

        holder.btRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Thong bao xoa");
                builder.setMessage("Ban co chac chan muon xoa "+phone.getName());
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
    public void filterList(List<Phone> filterlist){
        mList = filterlist;
        notifyDataSetChanged();
    }
    public void add(Phone c){
        listBackUp.add(c);
        mList.add(c);
//        Toast.makeText(context, c.getName(), Toast.LENGTH_SHORT).show();
        notifyDataSetChanged();
    }

    public void update(int position,Phone phone){
        listBackUp.set(position,phone);
        mList.set(position,phone);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(mList!=null) return mList.size();
        return 0;
    }

    public class PhoneViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView img;
        private TextView tvName, tvDes, tvPrice;
        private Button btRemove;

        public PhoneViewHolder(@NonNull View itemView){
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
            if(mPhoneItem!=null){
                mPhoneItem.onItemClick(v,getAdapterPosition());
            }
        }
    }

    public interface PhoneItemListener{
        void onItemClick(View v, int position);
    }
}
