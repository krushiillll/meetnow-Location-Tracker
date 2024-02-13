package com.meetnow.location.tracker;

import static com.meetnow.location.tracker.Ads.InterAdClass.counter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;


public class Personal_Continue_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_continue_activity);
        AdsClass.loadBigNativeAd(this);
        TextView cl=findViewById(R.id.cl);
        cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Personalcontxinue();
            }
        });
    }

    public void Personalcontxinue() {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_Continue_Activity.this, Personal_FindLocation_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_Continue_Activity.this, Personal_FindLocation_Activity.class);
                    startActivity(intent);
                    
                }
            }).showIntAd(Personal_Continue_Activity.this);
        }
    }
}