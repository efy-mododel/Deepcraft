package com.deepcraft.minecraft;

import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setBuiltInZoomControls(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setDefaultTextEncodingName("utf-8");

        // Enable IndexedDB / LocalStorage / WebSQL
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        // Load the web assets
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
        webView.pauseTimers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
        webView.resumeTimers();
    }

    @Override
    public void onBackPressed() {
        // Do nothing or handle game pause
        // The game handles Escape internally in GameCanvas.tsx
        super.onBackPressed();
    }
}
