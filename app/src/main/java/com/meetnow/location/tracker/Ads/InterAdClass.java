package com.meetnow.location.tracker.Ads;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.meetnow.location.tracker.Personal_Splash_Activity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class InterAdClass {

    public static InterstitialAd mInterstitialAd;

    static OnDismiss onDismiss;
    public  static  int counter = 0;

    public InterAdClass() {
    }

    public InterAdClass(OnDismiss onDismiss) {
        this.onDismiss = onDismiss;
    }

    public static void loadIntAd(Context context) {

        AdRequest adRequest = new AdRequest.Builder().build();

        Log.e("inter--", "loadIntAd: " + Personal_Splash_Activity.interstitial_ads);
        InterstitialAd.load(context, Personal_Splash_Activity.interstitial_ads, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        Log.e("inter--", "loadIntAd--: " + interstitialAd);

                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.e("inter--", "loadIntAd---: " + loadAdError);
                        mInterstitialAd = null;
                    }
                });
    }

    public void showIntAd(Activity activity) {
        counter++;
        if (mInterstitialAd != null && counter >= Personal_Splash_Activity.frequency) {
            mInterstitialAd.show(activity);

            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();

                    mInterstitialAd = null;
                    InterAdClass.loadIntAd(activity);
                    onDismiss.onDismiss();
                    counter = 0;
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                    onDismiss.onDismiss();
                }
            });

        } else {
            Log.d("TAG", "The interstitial ad wasn't ready yet.");
            onDismiss.onDismiss();
        }
    }
}
