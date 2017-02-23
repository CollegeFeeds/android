package Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.GridView;

import com.example.nipunarora.dufeed.R;

import java.util.ArrayList;

import Adapters.BannerSliderPagerAdapter;
import Adapters.CategoryGridLayoutAdapter;
import DataModels.NewsBanner;

/**
 * Created by nipunarora on 27/01/17.
 */
public class HomeTab extends Fragment {
    ViewPager bannerslider;
    BannerSliderPagerAdapter bannerpageradapter;
    View rootview;
    Handler handler;
    Runnable runnable;
    GridView Catergories;
    public HomeTab()
    {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(R.layout.home_tab, container, false);
        return  rootview;
    }
    /********************************** SET UP VIEW PAGER AND HANDLER TO KEEP THE SLIDER MOVING ********************/
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bannerslider=(ViewPager)rootview.findViewById(R.id.BannerSlider);
        ArrayList<Fragment> bannerlist=(ArrayList<Fragment>)getActivity().getIntent().getSerializableExtra("NewsBannerList");
        if(bannerlist==null)
        {
            Log.d("intent Extra","it was null");
        }

        Log.d("BannerSlider",String.format("%d",bannerlist.size()));
        bannerpageradapter=new BannerSliderPagerAdapter(getChildFragmentManager(),bannerlist,getContext());
        bannerslider.setAdapter(bannerpageradapter);
        Catergories=(GridView)rootview.findViewById(R.id.categoryGridview);
        Catergories.setAdapter(new CategoryGridLayoutAdapter(getContext()));
        bannerslider.setOffscreenPageLimit(3);
        handler = new Handler();
        runnable = new Runnable() {
            public void run() {
                Integer position=bannerslider.getCurrentItem();

                if( position >= (bannerpageradapter.banners.size()-1)){
                    position = 0;
                }else{
                    position = position+1;
                }
                bannerslider.setCurrentItem(position,true);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);
    }
    /********************** REMOVE HANDLER MESSAGES WHEN THE FRAGMENT IS NOT VISIBLE ***********************/
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            if(handler!=null) {
                handler.postDelayed(runnable, 3000);
            }


        }
        else {
            if(handler!=null) {
                handler.removeCallbacks(runnable);
            }
        }
    }
}
