package com.meetnow.location.tracker;

import static com.meetnow.location.tracker.Ads.InterAdClass.counter;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;

public class Personal_Start_Activity extends AppCompatActivity {
    TextView personalstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_start_activity);

        personalstart = (TextView) findViewById(R.id.start);

        AdsClass.loadBigNativeAd(this);

        personalstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (counter > Personal_Splash_Activity.frequency) {
                    counter++;
                    Intent intent = new Intent(Personal_Start_Activity.this, Personal_DashBoard_Activity.class);
                    startActivity(intent);
                } else {
                    new InterAdClass(new OnDismiss() {
                        @Override
                        public void onDismiss() {
                            Intent intent = new Intent(Personal_Start_Activity.this, Personal_DashBoard_Activity.class);
                            startActivity(intent);
                        }
                    }).showIntAd(Personal_Start_Activity.this);
                }
            }
        });
    }

    public void pshare(View view) {

        Intent sendintent = new Intent();
        sendintent.setAction(Intent.ACTION_SEND);
        sendintent.setType("text/plain");
        sendintent.putExtra(Intent.EXTRA_TEXT, "Download Mobile Number Locator.\n https://play.google.com/store/apps/details?id=" + getPackageName());
        startActivity(Intent.createChooser(sendintent, "Choose one"));
    }

    @SuppressLint("WrongConstant")
    public void prate(View view) {

        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName()));
        intent.setFlags(268468224);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(this, "You don't have Google Play installed", 1).show();
        }
    }

    public void pprivacy(View view) {

        if (Personal_Start_Activity.this.pisOnline()) {
            Personal_Start_Activity.this.startActivity(new Intent(Personal_Start_Activity.this.getApplicationContext(), PersonalWebActivity.class));
        } else {
            Toast.makeText(Personal_Start_Activity.this, "No Internet Connection..", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean pisOnline() {

        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}