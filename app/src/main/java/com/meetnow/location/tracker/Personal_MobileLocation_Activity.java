package com.meetnow.location.tracker;

import static com.meetnow.location.tracker.Ads.InterAdClass.counter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;


public class Personal_MobileLocation_Activity extends AppCompatActivity {


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_mobile_location_activity);


        AdsClass.loadBigNativeAd(this);
    }

    public void MobileLocation(View view) {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_MobileLocation_Activity.this, Personal_MobileNumberFinder_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_MobileLocation_Activity.this, Personal_MobileNumberFinder_Activity.class);
                    startActivity(intent);
                }
            }).showIntAd(Personal_MobileLocation_Activity.this);
        }
    }

    public void GPSLocation(View view) {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_MobileLocation_Activity.this, Persoonal_GPSLiveLocation_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_MobileLocation_Activity.this, Persoonal_GPSLiveLocation_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_MobileLocation_Activity.this);
        }
    }


    public void back(View view) {

        onBackPressed();
    }
}