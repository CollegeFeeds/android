package Fragments;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
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
    LinearLayout bannerlinearlayout;
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
        bannerlinearlayout=(LinearLayout)rootview.findViewById(R.id.news);
        newsbanner=(NewsBanner)getArguments().getSerializable("NewsBanner");
        headline=(AppCompatTextView)rootview.findViewById(R.id.HeadlineText);
        headline.setText(newsbanner.title);
        return  rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mImageLoader = VolleySingleton.getInstance(getContext()).getImageLoader();
        mImageLoader.get(newsbanner.image_url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {

            /******************* SET LOADED IMAGE AS THE BACKGROUND FOR LINEAR LAYOUT ****************/
                BitmapDrawable back=new BitmapDrawable(response.getBitmap());
                bannerlinearlayout.setBackground(back);
            }

            @Override
            public void onErrorResponse(VolleyError error) {
                /************** SET ERROR IMAGE FOR BACKGROUND **********************/
                Log.d("image error",error.toString());
                bannerlinearlayout.setBackgroundResource(R.drawable.university);

            }
        });
    }
}
