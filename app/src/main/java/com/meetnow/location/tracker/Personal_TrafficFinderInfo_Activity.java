package com.meetnow.location.tracker;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;


import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class Personal_TrafficFinderInfo_Activity extends FragmentActivity implements OnMapReadyCallback {

    CheckBox pcheckTraffic, pcheckMyLocation;
    Spinner Personalspinner;
    FusedLocationProviderClient pFusedLocationClient;
    int PERMISSION_ID = 44;
    GoogleMap Map;
    Location Personallocation;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_traffic_finder_info_activity);

        Personalspinner = (Spinner) findViewById(R.id.spinner);
        pcheckTraffic = (CheckBox) findViewById(R.id.checkTraffic);
        pcheckMyLocation = (CheckBox) findViewById(R.id.checkMyLocation);

//        statusCheck();

        ArrayAdapter<CharSequence> charSequenceArrayAdapter = ArrayAdapter.createFromResource(this, R.array.map_array, android.R.layout.simple_spinner_item);
        charSequenceArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Personalspinner.setAdapter(charSequenceArrayAdapter);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync((OnMapReadyCallback) Personal_TrafficFinderInfo_Activity.this);

        pFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        pcheckMyLocation.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Map.setMyLocationEnabled(isChecked);
                pFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Personallocation = task.getResult();
                        if (Personallocation == null) {
                            PersonalstatusCheck();
                        } else {
                            Personallocation.getLatitude();
                            Personallocation.getLongitude();
                        }
                    }
                });
            }
        });

        pcheckTraffic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Map.setTrafficEnabled(isChecked);
            }
        });

        Personalspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                        Map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                        break;
                    case 1:
                        Map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                        break;
                    case 2:
                        Map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                        break;
                    case 3:
                        Map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
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

    private boolean PersonalcheckPermissions() {

        return ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void PersonalrequestPermissions() {

        ActivityCompat.requestPermissions(this, new String[]{
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_ID);
    }

    private boolean PersonalisLocationEnabled() {

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {

        Map = googleMap;

        if (PersonalcheckPermissions()) {

            if (PersonalisLocationEnabled()) {

                pFusedLocationClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                    @Override
                    public void onComplete(@NonNull Task<Location> task) {
                        Personallocation = task.getResult();
                        if (Personallocation == null) {
                            PersonalstatusCheck();
                        } else {
                            Personallocation.getLatitude();
                            Personallocation.getLongitude();
                            @SuppressLint("MissingPermission") LatLng TutorialsPoint = new LatLng(Personallocation.getLatitude(), Personallocation.getLongitude());
                            Map.moveCamera(CameraUpdateFactory.newLatLng(TutorialsPoint));
                        }
                    }
                });
//        mMap.setMyLocationEnabled(true);
                Map.getUiSettings().setZoomGesturesEnabled(true);

                Log.e("loc-", "onMapReady: " + Map);
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
}