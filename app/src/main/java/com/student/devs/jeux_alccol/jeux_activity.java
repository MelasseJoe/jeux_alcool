package com.student.devs.jeux_alccol;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class jeux_activity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeux);
        Intent intent = getIntent();

        WebView webview = (WebView)this.findViewById(R.id.webview);

        String html = intent.getStringExtra("html");

        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.loadUrl("file:///android_asset/html/" + html);

    }
}
