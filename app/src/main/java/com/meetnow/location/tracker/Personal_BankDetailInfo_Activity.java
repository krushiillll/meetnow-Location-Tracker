package com.meetnow.location.tracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;


public class Personal_BankDetailInfo_Activity extends AppCompatActivity {

    TextView PersonalTitleTV, pTVCheckbalNumber, pTVCustomerCare, pTVMiniStatement, pBankTV;
    ImageView pbankIcon;
    String data;
    String intVar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_bank_detail_info_activity);


        AdsClass.loadBigNativeAd(this);
//


        PersonalTitleTV = (TextView) findViewById(R.id.TitleTV);
        pTVCheckbalNumber = (TextView) findViewById(R.id.TVCheckbalNumber);
        pTVCustomerCare = (TextView) findViewById(R.id.TVCustomerCare);
        pTVMiniStatement = (TextView) findViewById(R.id.TVMiniStatement);
        pBankTV = (TextView) findViewById(R.id.BankTV);
        pbankIcon = (ImageView) findViewById(R.id.bankIcon);

        String name = getIntent().getStringExtra("name");
        String balance = getIntent().getStringExtra("balance");
        String customercare = getIntent().getStringExtra("customercare");
        int icon = getIntent().getIntExtra("icon", 0);
        String statement = getIntent().getStringExtra("statement");

        PersonalTitleTV.setText(name);
        pBankTV.setText(name);

        pTVCheckbalNumber.setText(balance);
        pTVCustomerCare.setText(customercare);
        pTVMiniStatement.setText(statement);

        pbankIcon.setImageResource(icon);

//        AdRequest adRequest = new AdRequest.Builder().build();
//        AdLoader adLoader = new AdLoader.Builder(getApplicationContext(), Splash_Activity.nat)
//                .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
//                    @Override
//                    public void onNativeAdLoaded(NativeAd nativeAd) {
//
//                        Log.e("natv--", "onNativeAdLoaded: " + nativeAd);
//
//                        FrameLayout frameLayout =
//                                findViewById(R.id.nativeAdView);
//                        NativeAdView adView = (NativeAdView) getLayoutInflater()
//                                .inflate(R.layout.native_view, null);
//                        populateNativeAdView(nativeAd, adView);
//                        frameLayout.removeAllViews();
//                        frameLayout.addView(adView);
//                    }
//                })
//                .withAdListener(new AdListener() {
//                    @Override
//                    public void onAdFailedToLoad(LoadAdError adError) {
//                    }
//                })
//                .withNativeAdOptions(new NativeAdOptions.Builder()
//                        .build())
//                .build();
//        adLoader.loadAd(new AdRequest.Builder().build());
//
//        AdView mAdView = new AdView(BankDetailInfo_Activity.this);
//        mAdView.setAdUnitId(Splash_Activity.banner);
//        banner.addView(mAdView);
//        mAdView.setAdSize(AdSize.SMART_BANNER);
//
//        mAdView.loadAd(adRequest);
//
//        AdRequest adRequest = new AdRequest.Builder().build();
//        InterstitialAd.load(BankDetailInfo_Activity.this, Splash_Activity.interstitial, adRequest,
//                new InterstitialAdLoadCallback() {
//                    @Override
//                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
//                        // The mInterstitialAd reference will be null until
//                        // an ad is loaded.
//                        mInterstitialAd = interstitialAd;
//                        Log.i("TAG", "onAdLoaded");
//                    }
//
//                    @Override
//                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                        // Handle the error
//                        Log.d("TAG", loadAdError.toString());
//                        mInterstitialAd = null;
//                    }
//                });
    }

//    public void fireAds(String adsUrl) {
//
//        Firebase.setAndroidContext(this);
//        Firebase firebase = new Firebase(adsUrl);
//
//        firebase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                data = dataSnapshot.getValue(String.class);
//
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//    }

//    private void nativeAd() {
//
////        if (Configer.getInstance(this).isShowNativeAds() && !Configer.getInstance(this).getNtv1().isEmpty()) {
//
//
//        }
//    }

//    private void populateNativeAdView(NativeAd nativeAd, NativeAdView adView) {
//
//        adView.setMediaView(adView.findViewById(R.id.ad_media));
//        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
//        adView.setBodyView(adView.findViewById(R.id.ad_body));
//        adView.setCallToActionView(adView.findViewById(R.id.ad_call_to_action));
//        adView.setIconView(adView.findViewById(R.id.ad_app_icon));
//        adView.setPriceView(adView.findViewById(R.id.ad_price));
//        adView.setStarRatingView(adView.findViewById(R.id.ad_stars));
//        adView.setStoreView(adView.findViewById(R.id.ad_store));
//        adView.setAdvertiserView(adView.findViewById(R.id.ad_advertiser));
//
//        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
//        adView.getMediaView().setMediaContent(nativeAd.getMediaContent());
//
//        if (nativeAd.getBody() == null) {
//            adView.getBodyView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getBodyView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
//        }
//
//        if (nativeAd.getCallToAction() == null) {
//            adView.getCallToActionView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getCallToActionView().setVisibility(View.VISIBLE);
//            ((Button) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
//        }
//
//        if (nativeAd.getIcon() == null) {
//            adView.getIconView().setVisibility(View.GONE);
//        } else {
//            ((ImageView) adView.getIconView()).setImageDrawable(
//                    nativeAd.getIcon().getDrawable());
//            adView.getIconView().setVisibility(View.VISIBLE);
//        }
//
//        if (nativeAd.getPrice() == null) {
//            adView.getPriceView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getPriceView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getPriceView()).setText(nativeAd.getPrice());
//        }
//
//        if (nativeAd.getStore() == null) {
//            adView.getStoreView().setVisibility(View.INVISIBLE);
//        } else {
//            adView.getStoreView().setVisibility(View.VISIBLE);
//            ((TextView) adView.getStoreView()).setText(nativeAd.getStore());
//        }
//
//        if (nativeAd.getStarRating() == null) {
//            adView.getStarRatingView().setVisibility(View.INVISIBLE);
//        } else {
//            ((RatingBar) adView.getStarRatingView())
//                    .setRating(nativeAd.getStarRating().floatValue());
//            adView.getStarRatingView().setVisibility(View.VISIBLE);
//        }
//
//        if (nativeAd.getAdvertiser() == null) {
//            adView.getAdvertiserView().setVisibility(View.INVISIBLE);
//        } else {
//            ((TextView) adView.getAdvertiserView()).setText(nativeAd.getAdvertiser());
//            adView.getAdvertiserView().setVisibility(View.VISIBLE);
//        }
//        adView.setNativeAd(nativeAd);
//    }

    public void LocatorAccountBalance(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + pTVCheckbalNumber.getText().toString()));
        startActivity(intent);
    }

    public void shareAccountBalance(View view) {

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("*/*");
        String shareBody = pBankTV.getText().toString() + " check balance number is:- " + pTVCheckbalNumber.getText().toString();
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via: "));
    }

    public void LocatorCallCustomerCare(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + pTVCustomerCare.getText().toString()));
        startActivity(intent);
    }

    public void LocatorshareCustomerCare(View view) {

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("*/*");
        String shareBody = pBankTV.getText().toString() + " customer care number is:- " + pTVCustomerCare.getText().toString();
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via: "));
    }

    public void LocatorCallMiniStatement(View view) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + pTVMiniStatement.getText().toString()));
        startActivity(intent);
    }

    public void LocatorshareMiniStatement(View view) {

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("*/*");
        String shareBody = pBankTV.getText().toString() + " check ministatement number is:- " + pTVMiniStatement.getText().toString();
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via: "));
    }

//    public void fireInt(String intUrl) {
//
//        Firebase.setAndroidContext(this);
//        Firebase firebase = new Firebase(intUrl);
//
//        firebase.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                intVar = dataSnapshot.getValue(String.class);
//
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//    }

    public void back(View view) {

        onBackPressed();

//        if (mInterstitialAd != null) {
//            mInterstitialAd.show(BankDetailInfo_Activity.this);
//            mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
//                @Override
//                public void onAdDismissedFullScreenContent() {
//                    super.onAdDismissedFullScreenContent();
//                    onBackPressed();
//                }
//            });
//        } else {
//            Log.d("TAG", "The interstitial ad wasn't ready yet.");
//
//        }
//        Configer.getInstance(this).showInterstitialAdsOnBack(BankDetailInfo_Activity.this, new OnFullScreenClosedListener() {
//            @Override
//            public void onClosed() {
//
//                onBackPressed();
//            }
//        });
    }
}