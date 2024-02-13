package com.meetnow.location.tracker;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.google.android.gms.ads.interstitial.InterstitialAd;



public class Personal_BsnlInfo_Activity extends AppCompatActivity {

    String data;

    String intVar;
    InterstitialAd InterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_bsnl_info_activity);


        AdsClass.loadBigNativeAd(this);

    }



    public void back(View view) {

        onBackPressed();

    }
}