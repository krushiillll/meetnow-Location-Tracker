package com.meetnow.location.tracker;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import com.meetnow.location.tracker.Ads.AdsClass;
import com.meetnow.location.tracker.Ads.InterAdClass;
import com.meetnow.location.tracker.Ads.OnDismiss;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.conn.util.InetAddressUtils;


import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Personal_DeviceInfo_Activity extends AppCompatActivity {

    Button personalGetInformation;
    TextView ptextViewSetInformation,
            pIDtv, pMANUFACTURER, pBRAND, pTYPE, pUSER, pSECURITY_PATCH, pResolution, pScreenDensity, pRefreshrate, pBackCamera, pFrontCamera, pSDKTV, pVersion,
            pcpucore, pmaxfrequency, pinstructionset, pnetworkType, pipAddress, pacAddress, poperatorTv, proamingTv;

    int value = 0;
    float value1 = 0;
    private static final int PERMISSION_REQUEST_CODE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_device_info_activity);


        AdsClass.loadBigNativeAd(this);

        PersonalinitViews();
        PersonalinitListeners();
    }

    private void PersonalinitViews() {

        ptextViewSetInformation = (TextView) findViewById(R.id.textViewSetInformation);
        pIDtv = (TextView) findViewById(R.id.ID);
        pMANUFACTURER = (TextView) findViewById(R.id.MANUFACTURER);
        pBRAND = (TextView) findViewById(R.id.BRAND);
        pTYPE = (TextView) findViewById(R.id.TYPE);
        pUSER = (TextView) findViewById(R.id.USER);
        pSECURITY_PATCH = (TextView) findViewById(R.id.SECURITY_PATCH);
        pResolution = (TextView) findViewById(R.id.Resolution);
        pScreenDensity = (TextView) findViewById(R.id.ScreenDensity);
        pRefreshrate = (TextView) findViewById(R.id.Refreshrate);
        pBackCamera = (TextView) findViewById(R.id.BackCamera);
        pFrontCamera = (TextView) findViewById(R.id.FrontCamera);
        pSDKTV = (TextView) findViewById(R.id.SDK);
        pVersion = (TextView) findViewById(R.id.Version);
        pcpucore = (TextView) findViewById(R.id.cpucore);
        pmaxfrequency = (TextView) findViewById(R.id.maxfreq);
        pinstructionset = (TextView) findViewById(R.id.instructionset);
        pnetworkType = (TextView) findViewById(R.id.networkType);
        pipAddress = (TextView) findViewById(R.id.ipAddress);
        pacAddress = (TextView) findViewById(R.id.macAddress);
        poperatorTv = (TextView) findViewById(R.id.operatorTv);
        proamingTv = (TextView) findViewById(R.id.roamingTv);

        personalGetInformation = (Button) findViewById(R.id.buttonGetInformation);
    }

    public static String PersonalgetIPAddress(boolean useIPv4) {

        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                List<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress().toUpperCase();
                        boolean isIPv4 = InetAddressUtils.isIPv4Address(sAddr);
                        if (useIPv4) {
                            if (isIPv4)
                                return sAddr;
                        } else {
                            if (!isIPv4) {
                                int delim = sAddr.indexOf('%'); // drop ip6 port suffix
                                return delim < 0 ? sAddr : sAddr.substring(0, delim);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private String PersonalgetMAC() {

        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        @SuppressLint("MissingPermission") String macAddress = wInfo.getMacAddress();
        return macAddress;
    }

    private String PersonalgetOperator() {

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String carrierName = telephonyManager.getNetworkOperatorName();
        return carrierName;
    }

    private void PersonalinitListeners() {

        personalGetInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new InterAdClass(new OnDismiss() {
                    @Override
                    public void onDismiss() {

                        PersonalgetCamerasMegaPixel();

                        String model = PersonalgetModel();
                        String ID = PersonalgetId();
                        String manu = PersonalgetManu();
                        String brand = PersonalgetBrand();
                        String type = PersonalgetType();
                        String user = PersonalgetUser();
                        String security = PersonalgetSecurity();

                        String SDK = PersonalgetSDKInfo();
                        String version = PersonalgetVersionInfo();

                        String ipaddress = PersonalgetIPAddress(true);
                        String MAC = PersonalgetMAC();
                        String operator = PersonalgetOperator();
                        String instructset = PersonalgetInstructset();
                        int core = PersonalgetNumberOfCores();
                        int maxfreq = 0;
                        try {
                            maxfreq = PersonalgetMaxFreq();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String nettype = PersonalgetNetworkClass(Personal_DeviceInfo_Activity.this);
                        boolean romaing = PersonalisRoaming(Personal_DeviceInfo_Activity.this);

                        // set information to text view
                        ptextViewSetInformation.setText(model);
                        pIDtv.setText(ID);
                        pMANUFACTURER.setText(manu);
                        pBRAND.setText(brand);
                        pTYPE.setText(type);
                        pUSER.setText(user);
                        pSECURITY_PATCH.setText(security);
                        pSDKTV.setText(SDK);
                        pVersion.setText(version);
                        pmaxfrequency.setText(maxfreq + " Ghz");
                        pcpucore.setText(core + "");
                        pinstructionset.setText(instructset + "");
                        pipAddress.setText(ipaddress + "");
                        pnetworkType.setText(nettype + "");
                        pacAddress.setText(MAC + "");
                        poperatorTv.setText(operator + "");
                        proamingTv.setText(romaing + "");
                        PersonalgetScreenResolution();

                    }
                }).showIntAd(Personal_DeviceInfo_Activity.this);
            }
        });
    }

    private int PersonalgetNumberOfCores() {

        if (Build.VERSION.SDK_INT >= 17) {
            return Runtime.getRuntime().availableProcessors();
        } else {
            return PersonalgetNumCoresOldPhones();
        }
    }

    private int PersonalgetNumCoresOldPhones() {

        //Private Class to display only CPU devices in the directory listing
        class CpuFilter implements FileFilter {
            @Override
            public boolean accept(File pathname) {
                //Check if filename is "cpu", followed by a single digit number
                if (Pattern.matches("cpu[0-9]+", pathname.getName())) {
                    return true;
                }
                return false;
            }
        }

        try {
            //Get directory containing CPU info
            File dir = new File("/sys/devices/system/cpu/");
            //Filter to only list the devices we care about
            File[] files = dir.listFiles(new CpuFilter());
            //Return the number of cores (virtual CPU devices)
            return files.length;
        } catch (Exception e) {
            //Default to return 1 core
            return 1;
        }
    }

    private String PersonalgetSDKInfo() {

        return Build.VERSION.SDK;
    }

    private String PersonalgetVersionInfo() {

        return Build.VERSION.RELEASE;
    }

    private String PersonalgetInstructset() {

        return Build.CPU_ABI + "," + Build.CPU_ABI2;
    }

    private String PersonalgetModel() {

        return Build.MODEL;
    }

    private String PersonalgetId() {

        return Build.ID;
    }

    private String PersonalgetManu() {

        return Build.MANUFACTURER;
    }

    private String PersonalgetBrand() {

        return Build.BRAND;
    }

    private String PersonalgetType() {

        return Build.TYPE;
    }

    private String PersonalgetUser() {

        return Build.USER;
    }

    private String PersonalgetSecurity() {

        return Build.VERSION.SECURITY_PATCH;
    }

    private void PersonalgetScreenResolution() {

        WindowManager wm = (WindowManager) Personal_DeviceInfo_Activity.this.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        value1 = display.getRefreshRate();
        metrics = new DisplayMetrics();
        Personal_DeviceInfo_Activity.this.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        value = (int) (getResources().getDisplayMetrics().density * 160f);
        pResolution.setText(width + " w   " + height + " h");
        pScreenDensity.setText(value + "");
        pRefreshrate.setText(value1 + " Hz");
    }

    public void PersonalgetCamerasMegaPixel() {

        if (PersonalcheckPermission()) {
            int mg = PersonalgetBackCameraResolutionInMp();
            int mg1 = PersonalgetFrontCameraResolutionInMp();
            pBackCamera.setText(mg + " MegaPixel");
            pFrontCamera.setText(mg1 + " MegaPixel");
        } else {
            PersonalrequestPermission();
        }
    }

    private boolean PersonalcheckPermission() {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            return false;
        }
        return true;
    }

    private void PersonalrequestPermission() {

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA},
                PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getApplicationContext(), "Permission Granted", Toast.LENGTH_SHORT).show();
                    PersonalgetBackCameraResolutionInMp();
                    // main logic
                } else {
                    Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                                != PackageManager.PERMISSION_GRANTED) {
                            PersonalshowMessageOKCancel("You need to allow access permissions",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                PersonalrequestPermission();
                                            }
                                        }
                                    });
                        }
                    }
                }
                break;
        }
    }

    private void PersonalshowMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {

        new AlertDialog.Builder(Personal_DeviceInfo_Activity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }

    public int PersonalgetBackCameraResolutionInMp() {

        int noOfCameras = Camera.getNumberOfCameras();
        float maxResolution = -1;
        long pixelCount = -1;
        for (int i = 0; i < noOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                Camera camera = Camera.open(i);
                Camera.Parameters cameraParams = camera.getParameters();
                for (int j = 0; j < cameraParams.getSupportedPictureSizes().size(); j++) {
                    long pixelCountTemp = cameraParams.getSupportedPictureSizes().get(j).width * cameraParams.getSupportedPictureSizes().get(j).height; // Just changed i to j in this loop
                    if (pixelCountTemp > pixelCount) {
                        pixelCount = pixelCountTemp;
                        maxResolution = ((float) pixelCountTemp) / (1024000.0f);
                    }
                }
                camera.release();
            }
        }
        return (int) maxResolution;
    }

    public int PersonalgetFrontCameraResolutionInMp() {

        int noOfCameras = Camera.getNumberOfCameras();
        float maxResolution = -1;
        long pixelCount = -1;
        for (int i = 0; i < noOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                Camera camera = Camera.open(i);
                Camera.Parameters cameraParams = camera.getParameters();
                for (int j = 0; j < cameraParams.getSupportedPictureSizes().size(); j++) {
                    long pixelCountTemp = cameraParams.getSupportedPictureSizes().get(j).width * cameraParams.getSupportedPictureSizes().get(j).height; // Just changed i to j in this loop
                    if (pixelCountTemp > pixelCount) {
                        pixelCount = pixelCountTemp;
                        maxResolution = ((float) pixelCountTemp) / (1024000.0f);
                    }
                }
                camera.release();
            }
        }
        return (int) maxResolution;
    }

    public boolean PersonalisRoaming(Context context) {

        try {
            if (Build.VERSION.SDK_INT < 17) {
                return (Settings.System.getInt(Personal_DeviceInfo_Activity.this.getContentResolver(), Settings.Secure.DATA_ROAMING, 0) == 1);
            }
            return (Settings.Global.getInt(Personal_DeviceInfo_Activity.this.getContentResolver(), Settings.Global.DATA_ROAMING, 0) == 1);
        } catch (Exception exception) {
            return false;
        }
    }

    private int PersonalgetMaxFreq() throws IOException {

        int maxFreq = -1;
        try {
            RandomAccessFile reader = new RandomAccessFile("/sys/devices/system/cpu/cpu0/cpufreq/stats/time_in_state", "r");
            boolean done = false;
            while (!done) {
                String line = reader.readLine();
                if (null == line) {
                    done = true;
                    break;
                }
                String[] splits = line.split("\\s+");
                assert (splits.length == 2);
                int timeInState = Integer.parseInt(splits[1]);
                if (timeInState > 0) {
                    int freq = Integer.parseInt(splits[0]) / 1000000;
                    if (freq > maxFreq) {
                        maxFreq = freq;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return maxFreq;
    }

    public String PersonalgetNetworkClass(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        if (info == null || !info.isConnected())
            return "-"; // not connected
        if (info.getType() == ConnectivityManager.TYPE_WIFI)
            return "WIFI";
        if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
            int networkType = info.getSubtype();
            switch (networkType) {
                case TelephonyManager.NETWORK_TYPE_GPRS:
                case TelephonyManager.NETWORK_TYPE_EDGE:
                case TelephonyManager.NETWORK_TYPE_CDMA:
                case TelephonyManager.NETWORK_TYPE_1xRTT:
                case TelephonyManager.NETWORK_TYPE_IDEN:     // api< 8: replace by 11
                case TelephonyManager.NETWORK_TYPE_GSM:      // api<25: replace by 16
                    return "2G";
                case TelephonyManager.NETWORK_TYPE_UMTS:
                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                case TelephonyManager.NETWORK_TYPE_HSDPA:
                case TelephonyManager.NETWORK_TYPE_HSUPA:
                case TelephonyManager.NETWORK_TYPE_HSPA:
                case TelephonyManager.NETWORK_TYPE_EVDO_B:   // api< 9: replace by 12
                case TelephonyManager.NETWORK_TYPE_EHRPD:    // api<11: replace by 14
                case TelephonyManager.NETWORK_TYPE_HSPAP:    // api<13: replace by 15
                case TelephonyManager.NETWORK_TYPE_TD_SCDMA: // api<25: replace by 17
                    return "3G";
                case TelephonyManager.NETWORK_TYPE_LTE:      // api<11: replace by 13
                case TelephonyManager.NETWORK_TYPE_IWLAN:    // api<25: replace by 18
                case 19: // LTE_CA
                    return "4G";
                case TelephonyManager.NETWORK_TYPE_NR:       // api<29: replace by 20
                    return "5G";
                default:
                    return "?";
            }
        }
        return "?";
    }

    public void back(View view) {

        onBackPressed();
    }
}