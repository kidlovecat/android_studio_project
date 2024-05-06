package com.example.quanlichitieu_tablayout.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.quanlichitieu_tablayout.fragment.FragmentHistory;
import com.example.quanlichitieu_tablayout.fragment.FragmentHome;
import com.example.quanlichitieu_tablayout.fragment.FragmentSearch;

public class FragmentAdapter extends FragmentStatePagerAdapter {
    private int numpage=3;
    public FragmentAdapter(@NonNull FragmentManager fm, int num) {
        super(fm,num);
        this.numpage = num;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        if(position == 1){
            FragmentHistory his = new FragmentHistory();
            return his;
        }
        if(position == 0){
            FragmentHome his = new FragmentHome();
            return his;
        }
        if(position == 2){
            FragmentSearch his = new FragmentSearch();
            return his;
        }
        return new FragmentHome();
    }

    @Override
    public int getCount() {
        return numpage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Home";
            case 1: return "History";
            case 2: return "Search";
        }
        return null;
    }
}
