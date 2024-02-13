package com.meetnow.location.tracker;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.meetnow.location.tracker.Ads.AdsClass;


public class Personal_ThankYou_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_thank_you_activity);


        AdsClass.loadSmallNativeAd(this);
        Toast.makeText(this, "Back again for exit...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}