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
                return new MyResultsTab();
            case 1:
                // Games fragment activity
                return new MyNoticesTab();
            case 2:
                // Movies fragment activity
                return new StarredNotice();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        super.getPageTitle(position);

        switch (position){
            case 0:
                return "My Result";
            case 1:
                return "My Notices";
            case 2:
                return "Starred Notices";

            default:
                return null;
        }
    }

}
