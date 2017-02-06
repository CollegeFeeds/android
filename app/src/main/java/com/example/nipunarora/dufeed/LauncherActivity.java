package com.example.nipunarora.dufeed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;


public class LauncherActivity extends AppCompatActivity {
    Handler mHandler;
    Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        mHandler=new Handler();
        mRunnable=new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(),HomeActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
                finish();
            }
        };
        mHandler.postDelayed(mRunnable,3000);
    }
}
