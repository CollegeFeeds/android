package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nipunarora.dufeed.R;

/**
 * Created by nipunarora on 27/01/17.
 */
public class HomeTab extends Fragment {
    View rootview;
    public HomeTab()
    {

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview=inflater.inflate(
                R.layout.home_tab, container, false);
        return  rootview;
    }
}
