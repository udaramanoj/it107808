package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public class MainActivity extends AppCompatActivity {

    private WebView mywebView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mywebView=(WebView) findViewById(R.id.webview);
        mywebView.setWebViewClient(new WebViewClient());
        mywebView.loadUrl("https://www.navy.lk/");
        WebSettings webSettings=mywebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        
        
        



        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            
            
            
            class mywebClient extends WebViewClient{
                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon){
                    super.onPageStarted(view,url,favicon);
                }
                @Override
                public boolean shouldOverrideUrlLoading(WebView view,String url){
                    view.loadUrl(url);
                    return true;
                }
            }
         
            public void onBackPressed(){
                if(mywebView.canGoBack()) {
                    mywebView.goBack();
                }
                else{
                    super.getClass();
                }
            }
            
            
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                // on below line displaying a log that admob ads has been initialized.
                Log.i("Admob", "Admob Initialized.");
            }
        });

        // on below line creating and initializing variable for adView.
        AdView adView = findViewById(R.id.adView);
        // on below line creating and initializing variable for adRequest
        AdRequest adRequest = new AdRequest.Builder().build();
        // on below line loading request inside our adview.
        adView.loadAd(adRequest);


    }


}