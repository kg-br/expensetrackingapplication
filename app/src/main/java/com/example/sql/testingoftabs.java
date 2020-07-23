package com.example.sql;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TabHost;
import android.widget.Toast;

public class testingoftabs extends AppCompatActivity {

    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testingoftabs);
        wv = (WebView) findViewById(R.id.webview);
        wv.loadUrl("https://surejob.in/save-money.html");

        final ProgressDialog progressDialog = new ProgressDialog(testingoftabs.this);
        progressDialog.setMessage("Fetching tips for you");
        progressDialog.show();

        wv.setWebViewClient(new WebViewClient() {
                                @Override
                                public void onPageFinished(WebView view, String url) {
                                    if (progressDialog.isShowing()) {
                                        progressDialog.dismiss();
                                    }
                                }

                            } );







        // wv.setWebViewClient(new WebViewClient());
        // WebSettings webSettings=wv.getSettings();
        // webSettings.setJavaScriptEnabled(true);


      /*  if (isOnline()) {

            //do whatever you want to do 
        } else {
            Toast.makeText(testingoftabs.this,"Connect to internet",Toast.LENGTH_LONG).show();

    }*/





    /*public boolean isOnline() {
        ConnectivityManager conMgr = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = conMgr.getActiveNetworkInfo();
        return true;
    }*/
}


}


