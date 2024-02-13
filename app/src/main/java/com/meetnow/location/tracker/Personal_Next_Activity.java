package com.meetnow.location.tracker;

import static com.meetnow.location.tracker.Ads.InterAdClass.counter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.model.InstallStatus;
import com.google.android.play.core.install.model.UpdateAvailability;


public class Personal_Next_Activity extends AppCompatActivity {

    TextView Locator_tv_next;
    private static final int MY_REQUEST_CODE = 100;

    private AppUpdateManager locatorappUpdateManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_next_activity);

        locatorcheckForAppUpdate();

        AdsClass.loadBigNativeAd(this);

        Locator_tv_next = (TextView) findViewById(R.id.tv_next);
        Locator_tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (counter > Personal_Splash_Activity.frequency) {
                    counter++;
                    Intent intent = new Intent(Personal_Next_Activity.this, Personal_Continue_Activity.class);
                    startActivity(intent);
                } else {
                    new InterAdClass(new OnDismiss() {
                        @Override
                        public void onDismiss() {
                            Intent intent = new Intent(Personal_Next_Activity.this, Personal_Continue_Activity.class);
                            startActivity(intent);
                        }
                    }).showIntAd(Personal_Next_Activity.this);
                }
            }
        });


    }

    private void locatorcheckForAppUpdate() {

        locatorappUpdateManager = AppUpdateManagerFactory.create(this);

        Task<AppUpdateInfo> appUpdateInfoTask = locatorappUpdateManager.getAppUpdateInfo();
        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
                try {
                    locatorappUpdateManager.startUpdateFlowForResult(appUpdateInfo, AppUpdateType.FLEXIBLE, this, MY_REQUEST_CODE);
                } catch (IntentSender.SendIntentException e) {
                    e.printStackTrace();
                }
            }
        });
        locatorappUpdateManager.registerListener(listener);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode != RESULT_OK) {
                Log.e("Update flow failed! Result code: ", "onActivityResult: " + resultCode);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        locatorappUpdateManager.unregisterListener(listener);
    }

    @Override
    protected void onResume() {
        super.onResume();

        locatorappUpdateManager.getAppUpdateInfo().addOnSuccessListener(appUpdateInfo -> {
            if (appUpdateInfo.installStatus() == InstallStatus.DOWNLOADED) {
                LocatorpopupSnackbarForCompleteUpdate();
            }
        });
    }

    InstallStateUpdatedListener listener = state -> {
        if (state.installStatus() == InstallStatus.DOWNLOADED) {
            LocatorpopupSnackbarForCompleteUpdate();
        }
    };

    private void LocatorpopupSnackbarForCompleteUpdate() {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content), "An update has just been downloaded.", Snackbar.LENGTH_INDEFINITE);
        snackbar.setAction("INSTALL", view -> locatorappUpdateManager.completeUpdate());
        snackbar.setActionTextColor(getResources().getColor(R.color.back));
        snackbar.show();
    }


}
