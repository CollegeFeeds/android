package DataModels;

import android.support.v4.app.Fragment;

import java.io.Serializable;

/**
 * Created by nipunarora on 14/02/17.
 */
/**************************************** A DataModel class for a particular News Banner *************************/
public class NewsBanner implements Serializable {
   public String image_url,news_url,title;

    public NewsBanner(String title1,String newsurl,String imgurl)
    {
        image_url=imgurl;
        news_url=newsurl;
        title=title1;
    }

}
