package com.example.nipunarora.dufeed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by nipunarora on 08/02/17.
 */
public class BannerSliderPagerAdapter extends FragmentStatePagerAdapter {
    /////---------------------------In this Banner adapter we have adopted an arraylist approach so that later we can add more fragments in this viewpager--------////////////
    public ArrayList<Fragment> banners;

    public BannerSliderPagerAdapter(FragmentManager fm,ArrayList<Fragment>banner)
    {
        super(fm);
        banners=banner;

    }

    @Override
    public Fragment getItem(int i) {


        return banners.get(i);
    }

    @Override
    public int getCount() {

        return banners.size();
    }
    //facilitating dynamic addition of banners
    public void updateBannerlist(Fragment newbanner)
    {
        banners.add(newbanner);

    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
