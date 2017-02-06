package com.example.nipunarora.dufeed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nipunarora on 27/01/17.
 */
public class MyNoticesTab extends Fragment {
    View rootview;
    public MyNoticesTab()
    {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            rootview=inflater.inflate(
                    R.layout.mynotice_tab, container, false);
            return  rootview;

    }
}
