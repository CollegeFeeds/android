package Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.example.nipunarora.dufeed.R;
import com.example.nipunarora.dufeed.VolleySingleton;

import java.io.Serializable;

import DataModels.NewsBanner;

/**
 * Created by nipunarora on 16/02/17.
 */
public class NewsBannerFragment extends Fragment implements Serializable {
    View rootview;
    ImageView bannerimg;
    AppCompatTextView headline;
    NewsBanner newsbanner;
    ImageLoader mImageLoader;

    public NewsBannerFragment()
    {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /*************************** EXTRACT ARGS AND SET TITLE AND
         ON CLICK TO OPEN BROWSER(first approach would see the implementation of browser,later we will move to webview)/WEB VIEW TO VIEW THE NEWS *****/
        rootview=inflater.inflate(R.layout.newsbanner_fragment, container, false);
        bannerimg=(ImageView)rootview.findViewById(R.id.bannerimage);
        newsbanner=(NewsBanner)getArguments().getSerializable("NewsBanner");
        headline=(AppCompatTextView)rootview.findViewById(R.id.HeadlineText);
        headline.setText(newsbanner.title);
        return  rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImageLoader = VolleySingleton.getInstance(getContext()).getImageLoader();
        mImageLoader.get(newsbanner.image_url,ImageLoader.getImageListener(bannerimg,R.drawable.university,R.drawable.university));
    }
}
