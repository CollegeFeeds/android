package com.example.nipunarora.dufeed;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;
import java.util.List;


public class LauncherActivity extends AppCompatActivity {
    Handler mHandler;
    Runnable mRunnable;
    RequestQueue requestqueue;
    NewsDatabaseHandler dbnewshandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        requestqueue=VolleySingleton.getInstance(getApplicationContext()).getRequestQueue();
        dbnewshandler=new NewsDatabaseHandler(this);

        /*************************** SETTING UP THE NEWS HEADLINE BANNERS *******************************/
        /***** SET UP THE SHARED PREFERENCES(The Approach here is to create a shared preference
         to check whether the headlines were loaded into the database,if loaded once new requests for headlines would be made in the main app  ******/

        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("Preferences",getApplicationContext().MODE_PRIVATE);
        Boolean doWeNeedDBNewsDownload = sharedPref.getBoolean("headline_dbload",false);
        if(!doWeNeedDBNewsDownload)
            {
                getDuNews();
            }
        /*mHandler=new Handler();
        mRunnable=new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        };
        mHandler.postDelayed(mRunnable,3000);*/
    }
    private void getDuNews()
    {
        /*********************************** Send request for latest news....Parse json....Inject into Database and
         on succesful injection invert the boolean doweneeddbnewsdowload in the shared preference ****************/

        /*************************************** Request For News From Server ****************************************************/

        StringRequest getNews = new StringRequest(Request.Method.GET, "http://139.59.40.238:88/api/duNews/1",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                        /***************** JSON PARSING OF THE RESPONSE*********************/
                        try{
                            JSONObject res=new JSONObject(response);
                            int Json_length=res.length();
                            JSONArray key_array=res.names();
                            for (int i=0;i<Json_length;++i)
                            {
                                JSONObject temp=key_array.getJSONObject(i);
                                dbnewshandler.addBanner(new NewsBanner(temp.getString("title"),temp.getString("linkf"),temp.getString("imagelink")));
                            }

                        }
                        catch (Exception e)
                        {
                            Log.d("JSON Parse Error",e.toString());
                        }
                        /***************** END OF JSON PARSING *******************************/

                        /************************* Inverting the doweneedbnewsdowload Boolean *******************/
                        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("Preferences",getApplicationContext().MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPref.edit();
                        editor.putBoolean("headline_dbload",true );
                        editor.commit();
                        /******************************************** Invert Complete ************************/

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error", error.toString());
                    }
                }
        );
        getNews.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestqueue.add(getNews);

        /************************************* End of News request **************************************/


    }
}
