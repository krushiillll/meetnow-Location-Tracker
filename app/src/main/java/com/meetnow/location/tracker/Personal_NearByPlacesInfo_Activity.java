package com.meetnow.location.tracker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;


public class Personal_NearByPlacesInfo_Activity extends AppCompatActivity {

    String[] places = {"restaurant", "bar", "cafe", "delivery", "lodging", "atm", "beauty salon", "bank", "dry cleaning", "hospital", "gas station",
            "pharmacy", "park", "gym", "art gallery", "stadium", "night club", "amusement park", "movie theater", "museum", "groceries", "book store",
            "car dealers", "home garden store", "clothing store", "shopping mall", "electronics store", "jewelry store"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_near_by_places_info_activity);


        AdsClass.loadSmallNativeAd(this);

        PersonalstatusCheck();
    }

    public void PersonalstatusCheck() {

        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            PersonalbuildAlertMessageNoGps();
        }
    }

    private void PersonalbuildAlertMessageNoGps() {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable your GPS")
                .setCancelable(false)
                .setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                    }
                })
                .setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    public void onClick(final DialogInterface dialog, final int id) {
                        dialog.cancel();
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }

    public void PersonalgetNearByPlaces(int i) {

        String placesStr = this.places[i];

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://maps.google.co.in/maps?q=" + placesStr));
        startActivity(intent);
    }

    public void PersonalResturant(View view) {

        PersonalgetNearByPlaces(0);
    }

    public void pBar(View view) {

        PersonalgetNearByPlaces(1);
    }

    public void pCoffee(View view) {

        PersonalgetNearByPlaces(2);
    }

    public void pDelivery(View view) {

        PersonalgetNearByPlaces(3);
    }

    public void pHotel(View view) {

        PersonalgetNearByPlaces(4);
    }

    public void pATM(View view) {

        PersonalgetNearByPlaces(5);
    }

    public void pBeauty_salon(View view) {

        PersonalgetNearByPlaces(6);
    }

    public void pBank(View view) {

        PersonalgetNearByPlaces(7);
    }

    public void pDry_clean(View view) {

        PersonalgetNearByPlaces(8);
    }

    public void pHospital(View view) {

        PersonalgetNearByPlaces(9);
    }

    public void pGas(View view) {

        PersonalgetNearByPlaces(10);
    }

    public void pPharmacy(View view) {

        PersonalgetNearByPlaces(11);
    }

    public void pPark(View view) {

        PersonalgetNearByPlaces(12);
    }

    public void pGym(View view) {

        PersonalgetNearByPlaces(13);
    }

    public void pArt(View view) {

        PersonalgetNearByPlaces(14);
    }

    public void pStadium(View view) {

        PersonalgetNearByPlaces(15);
    }

    public void pNight_life(View view) {

        PersonalgetNearByPlaces(16);
    }

    public void pAmusement_park(View view) {

        PersonalgetNearByPlaces(17);
    }

    public void pMovies(View view) {

        PersonalgetNearByPlaces(18);
    }

    public void pMuseum(View view) {

        PersonalgetNearByPlaces(19);
    }

    public void pGrocery(View view) {

        PersonalgetNearByPlaces(20);
    }

    public void pBook(View view) {

        PersonalgetNearByPlaces(21);
    }

    public void pCar_dealers(View view) {

        PersonalgetNearByPlaces(22);
    }

    public void pHome_garden(View view) {

        PersonalgetNearByPlaces(23);
    }

    public void pApparel(View view) {

        PersonalgetNearByPlaces(24);
    }

    public void pShopping(View view) {

        PersonalgetNearByPlaces(25);
    }

    public void pElectronics(View view) {

        PersonalgetNearByPlaces(26);
    }

    public void pJewelry(View view) {

        PersonalgetNearByPlaces(27);
    }

    public void back(View view) {

        onBackPressed();
//        if (mInterstitialAd != null) {
//            mInterstitialAd.show(NearByPlacesInfo_Activity.this);
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

//        Configer.getInstance(this).showInterstitialAdsOnBack(NearByPlacesInfo_Activity.this, new OnFullScreenClosedListener() {
//            @Override
//            public void onClosed() {
//
//                onBackPressed();
//            }
//        });
    }
}