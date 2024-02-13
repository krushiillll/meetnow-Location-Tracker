package com.meetnow.location.tracker;

import static com.meetnow.location.tracker.Ads.AdsClass.initAd;
import static com.meetnow.location.tracker.Ads.AdsClass.preloadAdmobBignative;
import static com.meetnow.location.tracker.Ads.AdsClass.preloadAdmobSmallnative;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.meetnow.location.tracker.Ads.Datum;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.MyApi;
import com.meetnow.location.tracker.Ads.MyRetrofit;
import com.meetnow.location.tracker.openaaaads.AppOpenManager;
import com.meetnow.location.tracker.openaaaads.getDataListner;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import unified.vpn.sdk.AuthMethod;
import unified.vpn.sdk.ClientInfo;
import unified.vpn.sdk.CompletableCallback;
import unified.vpn.sdk.HydraTransport;
import unified.vpn.sdk.HydraTransportConfig;
import unified.vpn.sdk.HydraVpnTransportException;
import unified.vpn.sdk.NetworkRelatedException;
import unified.vpn.sdk.OpenVpnTransportConfig;
import unified.vpn.sdk.PartnerApiException;
import unified.vpn.sdk.SdkNotificationConfig;
import unified.vpn.sdk.SessionConfig;
import unified.vpn.sdk.TrackingConstants;
import unified.vpn.sdk.TrafficRule;
import unified.vpn.sdk.TransportConfig;
import unified.vpn.sdk.UnifiedSdk;
import unified.vpn.sdk.User;
import unified.vpn.sdk.VpnException;
import unified.vpn.sdk.VpnPermissionDeniedException;
import unified.vpn.sdk.VpnPermissionRevokedException;
import unified.vpn.sdk.VpnState;
import unified.vpn.sdk.VpnStateListener;

public class Personal_Splash_Activity extends AppCompatActivity implements VpnStateListener {

    private AppOpenManager manager;
    boolean is_splash_ad_loaded = false;
    boolean on_sucess = false;


    public static String add_open_ads = "";
    public static String banner_ads = "";
    public static String interstitial_ads = "";
    public static String interstitial_ads2 = "";
    public static String rewarded_ads = "";
    public static String native_ads = "";
    public static String vpn_server_url = "";
    public static String vpn_key = "";
    public static String country = "";
    public static String web_url = "";
    public static int vpn_status = 0;
    public static int frequency = 0;

    private static final String TAG = "SplashActivity---";
    public static UnifiedSdk unifiedSDK;
    public static int countStart = 0;
    private String selectedCountry;
    private String selectedCountryName;
    private static final String CHANNEL_ID = "global-vpn-pro";
    public static final String appSecretCode = "854df6289er6787sdf58sdr5wer6897sr587asdf858";

    public void ADSinit(final Activity activity, final getDataListner myCallback1) {
        final String app_open_id = add_open_ads;
        if (!app_open_id.isEmpty()) {
            loadAppOpenAd(activity, myCallback1);
        }

        String app_open_id2 = add_open_ads;
        if (!app_open_id.isEmpty()) {
            if (is_splash_ad_loaded) {
                manager.showAdIfAvailable(new AppOpenManager.splshADlistner() {
                    @Override
                    public void onsuccess() {
                        myCallback1.onsuccess();
                    }

                    @Override
                    public void onError(String error) {
                        myCallback1.onsuccess();
                    }
                });
            } else {
                on_sucess = true;
            }
        } else if (!app_open_id2.isEmpty()) {
            on_sucess = true;
            loadAppOpenAd(activity, myCallback1);
        } else {
            myCallback1.onsuccess();
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_splash_activity);

        new Prefs.Builder()
                .setContext(this)
                .setMode(ContextWrapper.MODE_PRIVATE)
                .setPrefsName(getPackageName())
                .setUseDefaultSharedPreference(true)
                .build();

        Prefs.putString("pw1", appSecretCode);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {


            }
        });

        MyRetrofit.retrofit.create(MyApi.class).getResponse().enqueue(new Callback<Datum>() {
            @Override
            public void onResponse(Call<Datum> call, Response<Datum> response) {

                Log.d("==-==", "onResponse: body  -->  " + response.body());
                Log.d("==-==", "onResponse: getData --->  " + response.body());


                Personal_Splash_Activity.web_url = response.body().getWebUrl();
                Personal_Splash_Activity.add_open_ads = response.body().getAddOpenAds();
                Personal_Splash_Activity.banner_ads = response.body().getBannerAds();
                Personal_Splash_Activity.interstitial_ads = response.body().getInterstitialAds();
                Personal_Splash_Activity.interstitial_ads2 = response.body().getInterstitialAds2();
                Personal_Splash_Activity.rewarded_ads = response.body().getRewardedAds();
                Personal_Splash_Activity.native_ads = response.body().getNativeAds();
                Personal_Splash_Activity.vpn_server_url = response.body().getVpnServerUrl();
                Personal_Splash_Activity.vpn_key = response.body().getVpnKey();
                Personal_Splash_Activity.country = response.body().getCountry();
                Personal_Splash_Activity.vpn_status = Integer.parseInt(response.body().getVpnStatus());
                Personal_Splash_Activity.frequency = Integer.parseInt(response.body().getFrequency());
                Log.d("yyyy", "onResponse: " + Personal_Splash_Activity.add_open_ads);

                InterAdClass.loadIntAd(Personal_Splash_Activity.this);
                preloadAdmobBignative(Personal_Splash_Activity.this);
                preloadAdmobSmallnative(Personal_Splash_Activity.this);

                Log.e("=======", "onResponse: " + Personal_Splash_Activity.web_url);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.add_open_ads);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.banner_ads);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.interstitial_ads);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.interstitial_ads2);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.rewarded_ads);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.native_ads);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.vpn_server_url);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.country);
                Log.e("=======", "onResponse: " + Personal_Splash_Activity.vpn_status);
                Log.e("=======", "onResponsefrequency: " + Personal_Splash_Activity.frequency);


                Log.e("818181", "onResponse: response = " + response.body());
                Log.e("818181", "onResponse: response.raw() = " + response.raw());
                Log.e("818181", "onResponse: response.message() = " + response.message());
                Log.e("818181", "onResponse: response.body().toString() = " + response.body().toString());


                if (Personal_Splash_Activity.vpn_status == 1) {

                    initAd(Personal_Splash_Activity.this);
                    initUI();
                }
                if (Personal_Splash_Activity.vpn_status == 0) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ADSinit(Personal_Splash_Activity.this, new getDataListner() {
                                @Override
                                public void onsuccess() {

                                    if (is_splash_ad_loaded) {
                                        manager.showAdIfAvailable(new AppOpenManager.splshADlistner() {
                                            @Override
                                            public void onsuccess() {
                                                Intent intent = new Intent(getApplicationContext(), Personal_Next_Activity.class);
                                                startActivity(intent);

                                            }

                                            @Override
                                            public void onError(String error) {
                                                Intent intent = new Intent(getApplicationContext(), Personal_Next_Activity.class);
                                                startActivity(intent);

                                            }
                                        });
                                    } else {
                                        on_sucess = true;
                                    }
                                }
                            });

                        }
                    }, 9000);
                }
            }

            @Override
            public void onFailure(Call<Datum> call, Throwable t) {
                Intent intent = new Intent(getApplicationContext(), Personal_Next_Activity.class);
                startActivity(intent);

            }

        });

    }

    @Override
    public void vpnStateChanged(@NonNull VpnState vpnState) {

    }

    @Override
    public void vpnError(@NonNull VpnException e) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("showed", "onShowAdComplete: " + "adshowed---");

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unifiedSDK.getVpn().stop(null, CompletableCallback.EMPTY);
    }

    private void initUI() {

        isNetworkConnected();
        nextToActivity();
    }

    private void nextToActivity() {

        initHydraSdk();

        if (true) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    connectToVpn();
                }
            }, 9000);
        } else {
        }
    }


    private void connectToVpn() {

        unifiedSDK.getBackend().isLoggedIn(new unified.vpn.sdk.Callback<Boolean>() {
            @Override
            public void success(Boolean isLoggedIn) {
                if (isLoggedIn) {
                    List<String> fallbackOrder = new ArrayList<>();
                    fallbackOrder.add(HydraTransport.TRANSPORT_ID);
                    List<String> bypassDomains = new LinkedList<>();
                    bypassDomains.add("*wtfismyip.com");
                    unifiedSDK.getVpn().start(new SessionConfig.Builder()
                                    .withReason(TrackingConstants.GprReasons.M_UI)
                                    .withTransportFallback(fallbackOrder)
                                    .withTransport(HydraTransport.TRANSPORT_ID)
                                    .withVirtualLocation(selectedCountry)
                                    .addDnsRule(TrafficRule.Builder.bypass().fromDomains(bypassDomains))
                                    .build(),
                            new CompletableCallback() {
                                @Override
                                public void complete() {
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            preloadAdmobBignative(Personal_Splash_Activity.this);
                                            preloadAdmobSmallnative(Personal_Splash_Activity.this);

                                            ADSinit(Personal_Splash_Activity.this, new getDataListner() {
                                                @Override
                                                public void onsuccess() {

                                                    if (is_splash_ad_loaded) {
                                                        manager.showAdIfAvailable(new AppOpenManager.splshADlistner() {
                                                            @Override
                                                            public void onsuccess() {
                                                                Intent intent = new Intent(getApplicationContext(), Personal_Next_Activity.class);
                                                                startActivity(intent);
                                                            }

                                                            @Override
                                                            public void onError(String error) {
                                                                Intent intent = new Intent(getApplicationContext(), Personal_Next_Activity.class);
                                                                startActivity(intent);
                                                            }
                                                        });
                                                    } else {
                                                        on_sucess = true;
                                                    }
                                                }
                                            });

                                        }
                                    }, 9000);


                                }

                                @Override
                                public void error(@NonNull VpnException e) {
                                    Intent intent = new Intent(getApplicationContext(), Personal_Next_Activity.class);
                                    startActivity(intent);
                                }
                            });

                } else {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            connectToVpn();


                        }
                    }, 9000);
                }
            }

            @Override
            public void failure(@NonNull VpnException e) {

                HandleErrors(e);
            }

        });
    }

    private boolean isNetworkConnected() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo() != null;
    }


    public void HandleErrors(Throwable e) {

        Log.w(TAG, e);
        if (e instanceof NetworkRelatedException) {
            showMessagees("Check internet connection");
        } else if (e instanceof VpnException) {
            if (e instanceof VpnPermissionRevokedException) {
                showMessagees("User revoked vpn permissions");
            } else if (e instanceof VpnPermissionDeniedException) {
                showMessagees("Allow to permissions & use Application");
            } else if (e instanceof HydraVpnTransportException) {
                HydraVpnTransportException hydraVpnTransportException = (HydraVpnTransportException) e;
                if (hydraVpnTransportException.getCode() == HydraVpnTransportException.HYDRA_ERROR_BROKEN) {
                    showMessagees("Connection with vpn server was lost");
                } else if (hydraVpnTransportException.getCode() == HydraVpnTransportException.HYDRA_DCN_BLOCKED_BW) {
                    showMessagees("Client traffic exceeded");
                } else {
                    showMessagees("Error in VPN transport");
                }
            } else {
                showMessagees("Error in VPN Service");
            }
        } else if (e instanceof PartnerApiException) {
            switch (((PartnerApiException) e).getContent()) {
                case PartnerApiException.CODE_NOT_AUTHORIZED:
                    showMessagees("User unauthorized");
                    break;
                case PartnerApiException.CODE_TRAFFIC_EXCEED:
                    showMessagees("Server unavailable");
                    break;
                default:
                    showMessagees("Other error. Check PartnerApiException constants");
                    break;
            }
        }
    }

    private void initHydraSdk() {

        Log.e("VPN---", "initHydraSdk: " + Personal_Splash_Activity.vpn_server_url + Personal_Splash_Activity.vpn_key);
        Log.e("con--", "initHydraSdk: " + Personal_Splash_Activity.country);
        try {
            unified.vpn.sdk.ClientInfo clientInfo = ClientInfo.newBuilder()
                    .addUrl(Personal_Splash_Activity.vpn_server_url)
                    .carrierId(Personal_Splash_Activity.vpn_key)
                    .build();
            unifiedSDK = UnifiedSdk.getInstance(clientInfo);
            UnifiedSdk.clearInstances();

            createNotificationChannel();

            List<TransportConfig> transportConfigList = new ArrayList<>();
            transportConfigList.add(HydraTransportConfig.create());
            transportConfigList.add(OpenVpnTransportConfig.tcp());
            transportConfigList.add(OpenVpnTransportConfig.udp());
            UnifiedSdk.update(transportConfigList, CompletableCallback.EMPTY);

            SdkNotificationConfig notificationConfig = SdkNotificationConfig.newBuilder()
                    .title(getResources().getString(R.string.app_name))
                    .channelId(CHANNEL_ID)
                    .build();
            UnifiedSdk.update(notificationConfig);

            UnifiedSdk.setLoggingLevel(Log.VERBOSE);

            movedNext();
            Locale locale = new Locale("", Prefs.getString("sname", Personal_Splash_Activity.country));

            selectedCountryName = locale.getDisplayCountry();
            selectedCountry = locale.getCountry().toLowerCase();

            UnifiedSdk.addVpnStateListener(this);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showMessagees(String s) {
        Toast.makeText(Personal_Splash_Activity.this, s, Toast.LENGTH_LONG).show();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String description = "VPN Active";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, getResources().getString(R.string.app_name), importance);
            channel.setDescription(description);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }


    private void movedNext() {

        try {
            runOnUiThread(() -> {

                AuthMethod authMethod = AuthMethod.anonymous();
                unifiedSDK.getBackend().login(authMethod, new unified.vpn.sdk.Callback<User>() {
                    @Override
                    public void success(User user) {
                        countStart = 0;
                    }

                    @Override
                    public void failure(VpnException e) {
                        if (countStart == 0) {
                            countStart++;
                        } else {

                        }
                    }
                });

            });
        } catch (final Exception ex) {
            ex.printStackTrace();
            Toast.makeText(Personal_Splash_Activity.this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void loadAppOpenAd(Activity activity, final getDataListner myCallback1) {
        manager = new AppOpenManager(activity);
        manager.fetchAd(new AppOpenManager.splshADlistner() {
            @Override
            public void onsuccess() {
                is_splash_ad_loaded = true;
                if (on_sucess) {
                    manager.showAdIfAvailable(new AppOpenManager.splshADlistner() {
                        @Override
                        public void onsuccess() {
                            myCallback1.onsuccess();
                        }

                        @Override
                        public void onError(String error) {
                            myCallback1.onsuccess();
                        }
                    });
                }
            }

            @Override
            public void onError(String error) {
                is_splash_ad_loaded = true;
                if (on_sucess) {
                    manager.showAdIfAvailable(new AppOpenManager.splshADlistner() {
                        @Override
                        public void onsuccess() {
                            myCallback1.onsuccess();
                        }

                        @Override
                        public void onError(String error) {
                            myCallback1.onsuccess();
                        }
                    });
                }
            }
        });
    }

}