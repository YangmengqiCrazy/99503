package com.example.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.bean.MyTabBean;

import java.util.ArrayList;

public class MyViewPagerFrag extends FragmentPagerAdapter {
  private ArrayList<Fragment> flist;

    public MyViewPagerFrag(FragmentManager fm, ArrayList<Fragment> flist) {
        super(fm);
        this.flist = flist;
    }

    @Override
    public Fragment getItem(int i) {
        return flist.get(i);
    }

    @Override
    public int getCount() {
        return flist.size();
    }

}
