package com.example.th105;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    WebView web;
    EditText osoite;
    String Edellinen;
    String Seuraava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
    }

    public void getWWW(View v){
        osoite = findViewById(R.id.editText);
        web.loadUrl("http://" + osoite.getText().toString());
    }

    public void refresh(View v){
        web.reload();
    }

    public void seuraava (View v){
        if(web!= null && web.canGoForward()){
            web.goForward();
        }
    }

    public void edellinen (View v) {
        Seuraava = web.getUrl();
        if (web != null && web.canGoBack()) {
                web.goBack();
                Edellinen = web.getUrl();
        } else {
                System.out.println("Ei enää historiaa");
        }
    }
}