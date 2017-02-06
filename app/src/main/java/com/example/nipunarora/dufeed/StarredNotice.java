package com.example.nipunarora.dufeed;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nipunarora on 27/01/17.
 */
public class StarredNotice extends Fragment {
    View rootview;
    public StarredNotice()
    {

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(
                R.layout.starrednotices_tab, container, false);
        return  rootview;
    }
}
