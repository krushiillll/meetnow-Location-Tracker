package com.meetnow.location.tracker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Personal_MobileNumberFinder_Activity extends AppCompatActivity {

    TextView pMobileNumberTVLocator, pNetworkTVLocator, pLocationTVLocator;
    RelativeLayout progressDialogLocator, pinfoRLLocator;
    EditText pnumberEDTLocator;
    String pstrNumberLocator;

    String data;

    String intVar;

    private static final String TAG = "MobileFinder---";
    NumberResponse numberResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_mobile_number_finder_activity);


        AdsClass.loadBigNativeAd(this);

        pMobileNumberTVLocator = (TextView) findViewById(R.id.MobileNumberTV);
        pNetworkTVLocator = (TextView) findViewById(R.id.NetworkTV);
        pLocationTVLocator = (TextView) findViewById(R.id.LocationTV);
        pnumberEDTLocator = (EditText) findViewById(R.id.numberEDT);
        progressDialogLocator = (RelativeLayout) findViewById(R.id.progressDialog);
        pinfoRLLocator = (RelativeLayout) findViewById(R.id.infoRL);

        statusCheck();


    }


    public void FindLocation(View view) {

        pstrNumberLocator = pnumberEDTLocator.getText().toString();
        new SearchNumber().execute(pstrNumberLocator);
    }



    public void back(View view) {

        onBackPressed();

    }

    public class SearchNumber extends AsyncTask<String, Void, Void> {

        @Override
        protected Void doInBackground(String... strings) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialogLocator.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            progressDialogLocator.setVisibility(View.GONE);
            pinfoRLLocator.setVisibility(View.VISIBLE);
        }

    }


    public final String getDataFromTextFile(Context context, String str) {

        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
            boolean z = true;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (z) {
                    z = false;
                } else {
                    sb.append(10);
                }
                sb.append(readLine);
            }
            String sb2 = sb.toString();
            try {
                bufferedReader.close();
            } catch (IOException e) {
                Log.d("StaticFragment", "sub ex 2 " + e);
            }
            return sb2;
        } catch (IOException e2) {
            StringBuilder w = new StringBuilder("m25a: ");
            w.append(e2.getMessage());
            Log.e("TAG", w.toString());
            return null;
        }
    }

    public void statusCheck() {

        final LocationManager manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            buildAlertMessageNoGps();
        }
    }

    private void buildAlertMessageNoGps() {

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
}