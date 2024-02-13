package com.meetnow.location.tracker;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;



public class Personal_Policy_Activity extends AppCompatActivity {

    WebView Personalwebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_policy_activity);

        Personalwebview = (WebView) findViewById(R.id.webview);

        Personalwebview.getSettings().setSaveFormData(true);
        Personalwebview.getSettings().setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:60.0) Gecko/20100101 Firefox/60.0");
        Personalwebview.getSettings().setAllowFileAccess(true);
//        webview.getSettings().setAppCacheEnabled(true);
        Personalwebview.getSettings().setJavaScriptEnabled(true);
        Personalwebview.getSettings().setDefaultTextEncodingName("utf-8");
        Personalwebview.getSettings().setDatabaseEnabled(true);
        Personalwebview.getSettings().setUseWideViewPort(true);
        Personalwebview.getSettings().setDomStorageEnabled(true);
        Personalwebview.getSettings().setLoadsImagesAutomatically(true);
        Personalwebview.getSettings().setBlockNetworkImage(false);
        Personalwebview.getSettings().setBlockNetworkLoads(false);
        Personalwebview.getSettings().setBuiltInZoomControls(true);
        Personalwebview.getSettings().setSupportZoom(false);
        Personalwebview.getSettings().setDisplayZoomControls(false);
        Personalwebview.getSettings().setUseWideViewPort(true);
        Personalwebview.getSettings().setLoadWithOverviewMode(true);
        this.Personalwebview.getSettings().setAllowContentAccess(true);
        this.Personalwebview.getSettings().setAllowFileAccess(true);
        this.Personalwebview.getSettings().setAllowFileAccessFromFileURLs(true);
        this.Personalwebview.getSettings().setAllowUniversalAccessFromFileURLs(true);
        this.Personalwebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
//        this.webview.getSettings().setAppCacheEnabled(true);
//        this.webview.getSettings().setAppCachePath(getCacheDir().getAbsolutePath());
        Personalwebview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        Personalwebview.getSettings().setPluginState(WebSettings.PluginState.ON);
        Personalwebview.setWebViewClient(new innerClass());
//        webview.loadUrl(Configer.getInstance(this).getPolicy_link());
    }

    public class innerClass extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.e("url---", "onPageStarted: " + url);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.e("url---", "onPageFinished: " + url);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}