package com.meetnow.location.tracker;

import static com.meetnow.location.tracker.Ads.InterAdClass.counter;
import static com.meetnow.location.tracker.Personal_Splash_Activity.frequency;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;
public class Personal_FindLocation_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_find_location_activity);
        AdsClass.loadBigNativeAd(this);
    }

    public void findLocation(View view) {

        System.out.println(">>>>>>>>>>>>>COUNTER: "+counter);
        System.out.println(">>>>>>>>>>>>>fffffff: "+Personal_Splash_Activity.frequency);
        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_FindLocation_Activity.this, Personal_Start_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_FindLocation_Activity.this, Personal_Start_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_FindLocation_Activity.this);
        }
    }
}