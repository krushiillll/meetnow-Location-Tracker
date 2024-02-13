package com.meetnow.location.tracker.openaaaads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

public class Myapplication extends Application implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Activity activity;


    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }


    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        this.activity = activity;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        this.activity = activity;
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onCreate() {
        super.onCreate();
        preferences = getSharedPreferences("your_prefs", 0);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        registerActivityLifecycleCallbacks(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        editor = preferences.edit();
        editor.putInt("resume_check", 0);
        editor.apply();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        Log.d("MyApp", "App in foreground");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void oncreate() {
        editor = preferences.edit();
        editor.putInt("resume_check", 0);
        editor.apply();
    }
}