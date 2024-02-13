package com.meetnow.location.tracker;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class Persoonal_GPSLiveLocation_Activity extends AppCompatActivity {

    TextView patitudeTV, plongitudetv, pcurrentpostaladdress;
    FusedLocationProviderClient pFusedLocationClient;
    int PERMISSION_ID = 44;
    Location plocation;

    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_gpslive_location_activity);


        AdsClass.shobannad(Persoonal_GPSLiveLocation_Activity.this);


        patitudeTV = (TextView) findViewById(R.id.LatitudeTV);
        plongitudetv = (TextView) findViewById(R.id.LongitudeTV);
        pcurrentpostaladdress = (TextView) findViewById(R.id.currentPostalAddress);

        pFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        PersonalLastLocation();
    }


    @SuppressLint("MissingPermission")
    private void PersonalLastLocation() {
        // check if permissions are given
        if (PersonalcheckPermissions()) {

            // check if location is enabled
            if (PersonalisLocationEnabledlocator()) {

                // getting last
                // location from
                // FusedLocationClient
                // object
                pFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        plocation = task.getResult();
                        if (plocation == null) {
                            PersonalrequestNewLocationData();
                        } else {
                            PersonalgetPostalAddress();
                            patitudeTV.setText(plocation.getLatitude() + "");
                            plongitudetv.setText(plocation.getLongitude() + "");
                        }
                    }
                });
            } else {
                Toast.makeText(this, "Please turn on" + " your location...", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            // if permissions aren't available,
            // request for permissions
            PersonalrequestPermissions();
        }
    }

    @SuppressLint("MissingPermission")
    private void PersonalrequestNewLocationData() {

        // Initializing LocationRequest
        // object with appropriate methods
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(5);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        // setting LocationRequest
        // on FusedLocationClient
        pFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        pFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
    }

    private LocationCallback mLocationCallback = new LocationCallback() {

        @Override
        public void onLocationResult(LocationResult locationResult) {

            Location mLastLocation = locationResult.getLastLocation();
            patitudeTV.setText(mLastLocation.getLatitude() + "");
            plongitudetv.setText(mLastLocation.getLongitude() + "");
        }
    };

    private boolean PersonalcheckPermissions() {

        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void PersonalrequestPermissions() {

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    private boolean PersonalisLocationEnabledlocator() {

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }


    private void PersonalgetPostalAddress() {

        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(plocation.getLatitude(), plocation.getLongitude(), 1);
            String cityName = addresses.get(0).getAddressLine(0);
            pcurrentpostaladdress.setText(cityName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        PersonalLastLocation();
    }

    public void Personalshowlocation(View view) {

        String Lat = patitudeTV.getText().toString();
        String Long = plongitudetv.getText().toString();

        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://maps.google.com/maps/" + Lat + Long));
        startActivity(intent);
        Toast.makeText(this, "You are here", Toast.LENGTH_SHORT).show();
    }

    public void back(View view) {

        onBackPressed();
//        Configer.getInstance(this).showInterstitialAdsOnBack(GPSLiveLocation_Activity.this, new OnFullScreenClosedListener() {
//            @Override
//            public void onClosed() {
//
//
//            }
//        });
    }
}