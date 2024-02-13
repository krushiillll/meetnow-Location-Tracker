package com.meetnow.location.tracker;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class PersonalWebActivity extends AppCompatActivity {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.personal_web_activity);


        WebView webView = findViewById(R.id.wvPrivacyPolicy);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (str.startsWith("http:") || str.startsWith("https:")) {
                    return false;
                }
                PersonalWebActivity.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                Toast.makeText(PersonalWebActivity.this, str, Toast.LENGTH_SHORT).show();
            }
        });
        webView.loadUrl(Glob.privacy_link);
    }
}
