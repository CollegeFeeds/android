package Adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.ArrayList;

import DataModels.NewsBanner;
import DatabaseHandlers.NewsDatabaseHandler;
import Fragments.NewsBannerFragment;

/**
 * Created by nipunarora on 08/02/17.
 */
public class BannerSliderPagerAdapter extends FragmentStatePagerAdapter {
    /////---------------------------In this Banner adapter we have adopted an arraylist approach so that later we can add more fragments in this viewpager--------////////////
    public ArrayList<Fragment> banners;
    NewsDatabaseHandler dbhandler;
    ArrayList<NewsBanner>bannerlist;

    public BannerSliderPagerAdapter(FragmentManager fm,ArrayList<Fragment>banner,Context context)
    {
        super(fm);
        banners=banner;
        dbhandler=new NewsDatabaseHandler(context);
        bannerlist=dbhandler.getBannerList();

    }

    @Override
    public Fragment getItem(int i) {

        /********************** CREATE A BUNDLE TO BE PASSED AS ARGUEMENT TO THE FRAGMENT **********************/
        Bundle args=new Bundle();
        args.putSerializable("NewsBanner", bannerlist.get(i));
        /********************** CREATE BANNER FRAGMENT,SET ARGS AND ADD IT TO THE LIST OF FRAGMENTS *****************/
        banners.get(i).setArguments(args);

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
