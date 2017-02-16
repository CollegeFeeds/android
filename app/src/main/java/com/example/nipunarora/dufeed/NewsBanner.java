package com.example.nipunarora.dufeed;

import android.support.v4.app.Fragment;

import java.io.Serializable;

/**
 * Created by nipunarora on 14/02/17.
 */
/**************************************** A DataModel class for a particular News Banner *************************/
public class NewsBanner implements Serializable {
   public String image_url,news_url;

    public NewsBanner(String imgurl,String newsurl)
    {
        image_url=imgurl;
        news_url=newsurl;
    }

}
