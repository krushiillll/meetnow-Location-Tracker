package com.meetnow.location.tracker;

import static com.meetnow.location.tracker.Ads.AdsClass.mNativeAd;
import static com.meetnow.location.tracker.Ads.AdsClass.populateNativeAdView;
import static com.meetnow.location.tracker.Ads.AdsClass.preloadAdmobBignative;
import static com.meetnow.location.tracker.Ads.InterAdClass.counter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;


public class Personal_DashBoard_Activity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_dash_board_activity);

        AdsClass.loadSmallNativeAd(this);
    }

    public void MobileLocation(View view) {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_MobileLocation_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_MobileLocation_Activity.class);
                    startActivity(intent);
                    
                }
            }).showIntAd(Personal_DashBoard_Activity.this);
        }
    }

    public void TrafficFinder(View view) {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_TrafficFinderInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_TrafficFinderInfo_Activity.class);
                    startActivity(intent);
                    
                }
            }).showIntAd(Personal_DashBoard_Activity.this);
        }
    }

    public void BankInformation(View view) {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_BankInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_BankInfo_Activity.class);
                    startActivity(intent);
                    
                }
            }).showIntAd(Personal_DashBoard_Activity.this);
        }
    }

    public void MobileTools(View view) {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_DashBoard_Activity.this, Peronal_MobileToolsInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_DashBoard_Activity.this, Peronal_MobileToolsInfo_Activity.class);
                    startActivity(intent);
                    
                }
            }).showIntAd(Personal_DashBoard_Activity.this);
        }
    }

    public void NearByPlaces(View view) {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_NearByPlacesInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_NearByPlacesInfo_Activity.class);
                    startActivity(intent);
                    
                }
            }).showIntAd(Personal_DashBoard_Activity.this);
        }
    }

    public void SIMCardInfo(View view) {

        if (counter > Personal_Splash_Activity.frequency) {
            counter++;
            Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_SIMCardInfo_Activity.class);
            startActivity(intent);
        } else {
            new InterAdClass(new OnDismiss() {
                @Override
                public void onDismiss() {
                    Intent intent = new Intent(Personal_DashBoard_Activity.this, Personal_SIMCardInfo_Activity.class);
                    startActivity(intent);
                    
                }
            }).showIntAd(Personal_DashBoard_Activity.this);
        }
    }

    public void LocatorcustomExitDialog(Activity activity) {

        final Dialog dialog = new Dialog(Personal_DashBoard_Activity.this);

        dialog.setContentView(R.layout.personal_exit_dialog_activity);

        TextView dialogButtonYes = (TextView) dialog.findViewById(R.id.btnExit);
        TextView dialogButtonNo = (TextView) dialog.findViewById(R.id.btnCancel);

        dialogButtonNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialogButtonYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                finishAffinity();
                finish();

            }
        });
        dialog.show();

        // native ad

        AdLoader.Builder adBuilder = new AdLoader.Builder(dialog.getContext(),Personal_Splash_Activity.native_ads);
        adBuilder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            @Override
            public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {

                if(isDestroyed() || isFinishing() || isChangingConfigurations()){
                    nativeAd.destroy();
                    return;
                }

                if(mNativeAd != null){
                    mNativeAd.destroy();
                }
                mNativeAd = nativeAd;
                FrameLayout adFrameLayout = dialog.findViewById(R.id.frameNativeAd);
                NativeAdView adView = (NativeAdView) dialog.getLayoutInflater().inflate(R.layout.ad_unified,null);
                populateNativeAdView(nativeAd,adView);
                adFrameLayout.removeAllViews();
                adFrameLayout.addView(adView);


            }

        });
        VideoOptions videoOptions = new VideoOptions.Builder().setStartMuted(true).build();
        NativeAdOptions nativeAdOptions = new NativeAdOptions.Builder().setVideoOptions(videoOptions).build();

        AdLoader adLoader = adBuilder.withAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                preloadAdmobBignative(activity);
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                preloadAdmobBignative(activity);
            }
        }).build();

        adLoader.loadAd(new AdRequest.Builder().build());

    }

    @Override
    public void onBackPressed() {

        LocatorcustomExitDialog(Personal_DashBoard_Activity.this);
    }
}