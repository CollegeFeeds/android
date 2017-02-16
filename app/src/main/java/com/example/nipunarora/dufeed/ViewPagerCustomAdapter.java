package com.example.nipunarora.dufeed;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by nipunarora on 27/01/17.
 */
public class ViewPagerCustomAdapter extends FragmentStatePagerAdapter {
    public ViewPagerCustomAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new HomeTab();
            case 1:
                // Movies fragment activity
                return new Starred();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 2;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        switch (position){
            case 0:
                return "Home";
            case 1:
                return "Starred";

            default:
                return null;
        }
    }

}
