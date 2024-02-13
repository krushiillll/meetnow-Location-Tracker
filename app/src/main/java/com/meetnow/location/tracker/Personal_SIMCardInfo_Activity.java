package com.meetnow.location.tracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;


public class Personal_SIMCardInfo_Activity extends AppCompatActivity {

    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_simcard_info_activity);


        AdsClass.loadSmallNativeAd(this);
    }

    public void pAirtelRL(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_AirtelInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_AirtelInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_SIMCardInfo_Activity.this);
        }
    }

    public void pAircelRL(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_AircelInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_AircelInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_SIMCardInfo_Activity.this);
        }
    }

    public void pVodafoneRL(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_VodafoneInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_VodafoneInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_SIMCardInfo_Activity.this);
        }
    }

    public void pTataDocomoRL(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_TataDocomoInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_TataDocomoInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_SIMCardInfo_Activity.this);
        }
    }

    public void pJioRL(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_JioInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_JioInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_SIMCardInfo_Activity.this);
        }
    }

    public void LpdeaRL(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, PersonalIdeaInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, PersonalIdeaInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_SIMCardInfo_Activity.this);
        }
    }

    public void pTelenorRL(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_TelenorInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_TelenorInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_SIMCardInfo_Activity.this);
        }
    }

    public void pBsnlRL(View view) {

        counter++;
        if (counter > Personal_Splash_Activity.frequency) {
            Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_BsnlInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_SIMCardInfo_Activity.this, Personal_BsnlInfo_Activity.class);
                    startActivity(intent);

                }
            }).showIntAd(Personal_SIMCardInfo_Activity.this);
        }
    }

    public void back(View view) {

        onBackPressed();
    }
}