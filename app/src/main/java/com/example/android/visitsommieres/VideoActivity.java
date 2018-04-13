package com.example.android.visitsommieres;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class VideoActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    String url;
    Button video1, video2, video3;
    TextView videoInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.appBarLayout).bringToFront();
        webView = findViewById(R.id.webview_video);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.setVisibility(View.INVISIBLE);
        videoInfo = findViewById(R.id.video_ID);
        video1 = findViewById(R.id.video_tour);
        video2 = findViewById(R.id.aerial_view);
        video3 = findViewById(R.id.local_hostel);
        video1.setOnClickListener(this);
        video2.setOnClickListener(this);
        video3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.video_tour:
                webView.setVisibility(View.VISIBLE);
                url=(getString(R.string.vid1));
                webView.loadUrl(url);
                videoInfo.setText(R.string.video_tour);
                break;
            case R.id.aerial_view:
                webView.setVisibility(View.VISIBLE);
                url=(getString(R.string.vid2));
                webView.loadUrl(url);
                videoInfo.setText(R.string.aerial);
                break;
            case R.id.local_hostel:
                webView.setVisibility(View.VISIBLE);
                url=(getString(R.string.vid3));
                webView.loadUrl(url);
                videoInfo.setText(R.string.hostel);
                break;
        }
    }
}
