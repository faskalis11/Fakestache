package com.example.ignas.fakestache;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Simonas on 2016-11-10.
 */

public class GalleryPagerAdapter extends FragmentStatePagerAdapter {
    private int numberOfTabs = 2;

    public GalleryPagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            //visos nuotraukos

            return GalleryFragment.newInstance("Pirmas tab'as");
        }else if(position == 1){
            //fakestache nuotraukos
            return GalleryFragment.newInstance("Antras tab'as");
        }else{
            return  null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
