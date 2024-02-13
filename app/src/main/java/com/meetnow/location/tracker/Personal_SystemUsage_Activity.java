package com.meetnow.location.tracker;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;


import java.io.File;

public class Personal_SystemUsage_Activity extends AppCompatActivity {

    Button pbuttonGetInformation;
    TextView ptotalram, pusedram, pavailableram, ptotalspace, pfreespacew, ptotalspace1, pfreespacew1, pbatteryper, pbatterycap, pbatterytemp, ptv_percentage;

    private ProgressBar ProgressBar;
    private int ProgressStatus = 0;
    private Context Context;
    int counter = 0;


    private BroadcastReceiver BroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
            float percentage = level / (float) scale;
            ProgressStatus = (int) ((percentage) * 100);
            ptv_percentage.setText("" + ProgressStatus + "%");
            ProgressBar.setProgress(ProgressStatus);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_system_usage_activity);
        PersonalinitViews();
        PersonalinitListeners();


        AdsClass.loadBigNativeAd(this);

        Context = getApplicationContext();
        IntentFilter iFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Context.registerReceiver(BroadcastReceiver, iFilter);
    }

    private void PersonalinitViews() {

        ptotalram = (TextView) findViewById(R.id.totalram);
        pusedram = (TextView) findViewById(R.id.usedram);
        pavailableram = (TextView) findViewById(R.id.availableram);
        ptotalspace = (TextView) findViewById(R.id.totalspace);
        pfreespacew = (TextView) findViewById(R.id.freespacew);
        ptotalspace1 = (TextView) findViewById(R.id.totalspace1);
        pfreespacew1 = (TextView) findViewById(R.id.freespacew1);
        pbatteryper = (TextView) findViewById(R.id.batteryper);
        pbatterycap = (TextView) findViewById(R.id.batterycap);
        pbatterytemp = (TextView) findViewById(R.id.batterytemp);
        ProgressBar = (ProgressBar) findViewById(R.id.mProgressBar);
        ptv_percentage = (TextView) findViewById(R.id.tv_percentage);
        pbuttonGetInformation = (Button) findViewById(R.id.buttonGetInformation);
    }

    private void PersonalinitListeners() {

        pbuttonGetInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter++;
                if (counter > Personal_Splash_Activity.frequency) {
                    int batl = PersonalgetBatteryper();
                    long batmah = PersonalgetBatteryCapacity(Personal_SystemUsage_Activity.this);
                    float bettemp = PersonalgetbatteryTemperature(Personal_SystemUsage_Activity.this);
                    float inte = PersonalgetInternalInfo();
                    float tinte = PersonalgettotalInternal();

                    pbatteryper.setText(batl + " %");
                    pbatterycap.setText(batmah + " MAH");
                    pbatterytemp.setText(bettemp + "°C");
                    ptotalspace.setText(tinte / 1000 + " GB");
                    pfreespacew.setText(inte / 1000 + " GB");
                    ptotalspace1.setText(tinte / 1000 + " GB");
                    pfreespacew1.setText(inte / 1000 + " GB");
                    PersonalgetRAMInfo();
                    ProgressBar.setVisibility(View.VISIBLE);
                    ptv_percentage.setVisibility(View.VISIBLE);

                } else {
                    new InterAdClass(new OnDismiss() {
                        @Override
                        public void onDismiss() {
                            int batl = PersonalgetBatteryper();
                            long batmah = PersonalgetBatteryCapacity(Personal_SystemUsage_Activity.this);
                            float bettemp = PersonalgetbatteryTemperature(Personal_SystemUsage_Activity.this);
                            float inte = PersonalgetInternalInfo();
                            float tinte = PersonalgettotalInternal();

                            pbatteryper.setText(batl + " %");
                            pbatterycap.setText(batmah + " MAH");
                            pbatterytemp.setText(bettemp + "°C");
                            ptotalspace.setText(tinte / 1000 + " GB");
                            pfreespacew.setText(inte / 1000 + " GB");
                            ptotalspace1.setText(tinte / 1000 + " GB");
                            pfreespacew1.setText(inte / 1000 + " GB");
                            PersonalgetRAMInfo();
                            ProgressBar.setVisibility(View.VISIBLE);
                            ptv_percentage.setVisibility(View.VISIBLE);

                        }
                    }).showIntAd(Personal_SystemUsage_Activity.this);
                }
            }
        });
    }

    private int PersonalgetBatteryper() {

        BatteryManager bm = (BatteryManager) Personal_SystemUsage_Activity.this.getSystemService(BATTERY_SERVICE);
        int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        return batLevel;
    }

    private void PersonalgetRAMInfo() {

        ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        activityManager.getMemoryInfo(mi);
        float freeMemory = mi.availMem / 1048576L;
        float totalMemory = mi.totalMem / 1048576L;
        float usedMemory = totalMemory - freeMemory;
        ptotalram.setText(totalMemory / 1000 + " GB");
        pusedram.setText(usedMemory / 1000 + " GB");
        pavailableram.setText(freeMemory / 1000 + " GB");
    }

    private float PersonalgetInternalInfo() {

        StatFs stat = new StatFs(Environment.getExternalStorageDirectory().getPath());
        float bytesAvailable;
        bytesAvailable = stat.getBlockSizeLong() * stat.getAvailableBlocksLong();
        float megAvailable = bytesAvailable / (1024 * 1024);
        return megAvailable;
    }

    private float PersonalgettotalInternal() {

        float totalSize = new File(getApplicationContext().getFilesDir().getAbsoluteFile().toString()).getTotalSpace();
        float totMb = totalSize / (1024 * 1024);
        return totMb;
    }

    public static float PersonalgetbatteryTemperature(Context context) {

        Intent intent = context.registerReceiver(null, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        float temp = ((float) intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE, 0)) / 10;
        return temp;
    }

    public long PersonalgetBatteryCapacity(Context context) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            BatteryManager mBatteryManager = (BatteryManager) context.getSystemService(Context.BATTERY_SERVICE);
            Integer chargeCounter = mBatteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CHARGE_COUNTER);
            Integer capacity = mBatteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);

            if (chargeCounter == Integer.MIN_VALUE || capacity == Integer.MIN_VALUE)
                return 0;

            return (chargeCounter / 1000) * capacity;
        }
        return 0;
    }

    public void back(View view) {

        onBackPressed();
    }
}