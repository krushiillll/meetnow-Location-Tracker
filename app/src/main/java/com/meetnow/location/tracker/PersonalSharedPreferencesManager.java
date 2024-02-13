package com.meetnow.location.tracker;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PersonalSharedPreferencesManager extends Application {

    private static PersonalSharedPreferencesManager sharePref = new PersonalSharedPreferencesManager();
    private static SharedPreferences PsharedPreferences;
    private static SharedPreferences.Editor Leditor;

    public static final String KEY_URI_FOR_ANDROID_11 = "URI_FOR_ANDROID_11";

    private static final String KEY_Date = "Date";
    private static final String KEY_IS_FIRST_TIME = "isFirstTime";
    public static final String KEY_VPN_BUTTON = "VPN_BUTTON";
    public static final String KEY_VPN_STATUS = "VPN_STATUS";
    public static final String KEY_VPN_CLOSE_BUTTON = "VPN_CLOSE_BUTTON";
    public static final String KEY_AUTO_CONNECT_VPN = "AUTO_CONNECT_VPN";

    public static boolean KEY_IS_DISPLAY_ONBOARDING = true;

    String KEY = "";
    String URL = "";

    public PersonalSharedPreferencesManager() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        PsharedPreferences = getSharedPreferences("Home WorkOut", MODE_PRIVATE);
    }

    public static boolean isKeyIsDisplayOnboarding() {
        return KEY_IS_DISPLAY_ONBOARDING;
    }

    public static void LocatorsetKeyIsDisplayOnboarding(boolean keyIsDisplayOnboarding) {
        KEY_IS_DISPLAY_ONBOARDING = keyIsDisplayOnboarding;
    }

    public static String getKeyUriForAndroid11() {
        return PsharedPreferences.getString(KEY_URI_FOR_ANDROID_11, "");
    }

    public static void setUriForAndroid11(String uri) {
        PsharedPreferences.edit().putString(KEY_URI_FOR_ANDROID_11, uri).apply();
    }

    public static PersonalSharedPreferencesManager getInstance(Context context) {
        if (PsharedPreferences == null) {
            PsharedPreferences = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
            Leditor = PsharedPreferences.edit();
        }
        return sharePref;
    }

    public void setVpnButton(int vpnButton) {

        Leditor.putInt(KEY_VPN_BUTTON, vpnButton).apply();

    }

    public int getVpnButton() {

        return PsharedPreferences.getInt(KEY_VPN_BUTTON, 0);
    }

    public void setVpnStatus(int vpnButton) {

        Leditor.putInt(KEY_VPN_STATUS, vpnButton).apply();

    }

    public int getVpnStatus() {

        return PsharedPreferences.getInt(KEY_VPN_STATUS, 0);
    }

    public void setVpnCloseButton(int vpnButton) {

        Leditor.putInt(KEY_VPN_CLOSE_BUTTON, vpnButton).apply();

    }

    public int getVpnCloseButton() {
        return PsharedPreferences.getInt(KEY_VPN_CLOSE_BUTTON, 0);
    }


    public void setAutoConnectVpn(boolean autoConnectVpn) {

        Leditor.putBoolean(KEY_AUTO_CONNECT_VPN, autoConnectVpn).apply();

    }

    public boolean getAutoConnectVpn() {

        return PsharedPreferences.getBoolean(KEY_AUTO_CONNECT_VPN, false);
    }

    public void setKey(String key) {
        Log.e("keyy--", "getKey: " + key);
        Leditor.putString(KEY, key);
        Leditor.commit();
    }

    public String getKey() {
        Log.e("keyy-", "getKey: " + "key");
        return PsharedPreferences.getString(KEY, "");
    }

    public void setUrl(String url) {
        Leditor.putString(URL, url);
        Leditor.commit();
    }

    public String getURL() {
        return  PsharedPreferences.getString(URL, "");
    }

    public void setKeyDate(String placeObjStr) {
        Leditor.putString(KEY_Date, placeObjStr);
        Leditor.commit();
    }

    public String getKeyDate() {
        return PsharedPreferences.getString(KEY_Date, "");
    }

    public void setisFirstTime(boolean placeObjStr) {
        Leditor.putBoolean(KEY_IS_FIRST_TIME, placeObjStr);
        Leditor.commit();
    }

    public boolean getisFirstTime() {
        return PsharedPreferences.getBoolean(KEY_IS_FIRST_TIME, true);
    }

    public void removePlaceObj() {
        Leditor.remove(KEY_Date);
        Leditor.commit();
    }

    public void clearAll() {
        Leditor.clear();
        Leditor.commit();
    }
}
