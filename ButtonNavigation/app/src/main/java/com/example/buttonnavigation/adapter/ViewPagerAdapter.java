package com.example.buttonnavigation.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.buttonnavigation.fragment.FragmentCafe;
import com.example.buttonnavigation.fragment.FragmentHome;
import com.example.buttonnavigation.fragment.FragmentNotification;
import com.example.buttonnavigation.fragment.FragmentSearch;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    int pageNum=4;
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new FragmentHome();
            case 1: return new FragmentNotification();
            case 2: return new FragmentSearch();
            case 3: return new FragmentCafe();
            default: return new FragmentHome();
        }

    }

    @Override
    public int getCount() {
        return pageNum;
    }
}
