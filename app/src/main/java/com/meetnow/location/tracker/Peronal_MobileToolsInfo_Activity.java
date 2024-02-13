package com.meetnow.location.tracker;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;



public class Peronal_MobileToolsInfo_Activity extends AppCompatActivity {

        int counter = 0;

    AudioManager LocatorauAudioManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_mobile_tools_info_activity);

        AdsClass.loadBigNativeAd(this);
    }

    public void DeviceInfo(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Peronal_MobileToolsInfo_Activity.this, Personal_DeviceInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Peronal_MobileToolsInfo_Activity.this, Personal_DeviceInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Peronal_MobileToolsInfo_Activity.this);
        }
    }



    public void AudioManager(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Peronal_MobileToolsInfo_Activity.this, Personal_AudioManager_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Peronal_MobileToolsInfo_Activity.this, Personal_AudioManager_Activity.class);
                    startActivity(intent);
                }
            }).showIntAd(Peronal_MobileToolsInfo_Activity.this);
        }
    }

    public void SystemUsage(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Peronal_MobileToolsInfo_Activity.this, Personal_SystemUsage_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Peronal_MobileToolsInfo_Activity.this, Personal_SystemUsage_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Peronal_MobileToolsInfo_Activity.this);
        }
    }


    public void back(View view) {

        onBackPressed();
    }
}