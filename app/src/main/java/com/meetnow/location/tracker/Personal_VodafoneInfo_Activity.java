package com.meetnow.location.tracker;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;


public class Personal_VodafoneInfo_Activity extends AppCompatActivity {

    String data;

    String intVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_vodafone_info_activity);


        AdsClass.loadSmallNativeAd(this);

    }



    public void back(View view) {

        onBackPressed();

    }
}