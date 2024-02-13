package com.meetnow.location.tracker;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import com.meetnow.location.tracker.Ads.AdsClass;


public class Personal_AudioManager_Activity extends AppCompatActivity {

    CheckBox personalcheckVibrateRingtone;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_audio_manager_activity);


        AdsClass.loadBigNativeAd(this);

        personalcheckVibrateRingtone = (CheckBox) findViewById(R.id.checkVibrateRingtone);
    }

    public void Personalrringtone(View view) {

        final Uri currentTone =
                RingtoneManager.getActualDefaultRingtoneUri(Personal_AudioManager_Activity.this,
                        RingtoneManager.TYPE_RINGTONE);
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_RINGTONE);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, currentTone);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
        startActivityForResult(intent, 999);
    }

    public void Personalnotification(View view) {

        final Uri currentTone =
                RingtoneManager.getActualDefaultRingtoneUri(Personal_AudioManager_Activity.this,
                        RingtoneManager.TYPE_NOTIFICATION);
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_NOTIFICATION);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, currentTone);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
        startActivityForResult(intent, 999);
    }

    public void Persoanlalarm(View view) {

        final Uri currentTone =
                RingtoneManager.getActualDefaultRingtoneUri(Personal_AudioManager_Activity.this,
                        RingtoneManager.TYPE_ALARM);
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_ALARM);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, currentTone);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
        startActivityForResult(intent, 999);
    }

    public void back(View view) {

        onBackPressed();
    }
}