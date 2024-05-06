package com.example.kiem_tra_1.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.kiem_tra_1.R;

public class SpinnerAdapter extends BaseAdapter {
        private int[] imgs= {R.drawable.samsung_logo,R.drawable.asus_logo,R.drawable.apple_logo,
                R.drawable.xiaomi_logo};

        private Context context;

        public SpinnerAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View item = LayoutInflater.from(context).inflate(R.layout.item_img_spinner,parent,false);
            ImageView img = item.findViewById(R.id.img);
            img.setImageResource(imgs[position]);
            return item;
        }
}
