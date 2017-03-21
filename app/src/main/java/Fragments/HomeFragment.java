package Fragments;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nipunarora.dufeed.R;
import Adapters.ViewPagerCustomAdapter;

/**
 * Created by nipunarora on 27/01/17.
 */
public class HomeFragment extends Fragment {
    TabLayout tblayout;
    ViewPager pager;
    View rootView;
    ViewPagerCustomAdapter tabsadapter;
    Integer[] Icons={R.drawable.home,R.drawable.star};
    public HomeFragment()
    {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         rootView = inflater.inflate(
                R.layout.home_fragment, container, false);
        return  rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tblayout= (TabLayout) rootView.findViewById(R.id.tblayout);
        pager=(ViewPager)rootView.findViewById(R.id.viewpager);
        tabsadapter = new ViewPagerCustomAdapter(getFragmentManager());
        pager.setAdapter(tabsadapter);
        if(tblayout!=null) {
            tblayout.setupWithViewPager(pager);
            setupTabIcons(tblayout);
        }


    }
    private void setupTabIcons(TabLayout tblayout)
    {
        tblayout.getTabAt(0).setIcon(Icons[0]);
        tblayout.getTabAt(1).setIcon(Icons[1]);

    }
}
