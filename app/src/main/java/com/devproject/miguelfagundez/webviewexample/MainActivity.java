package com.devproject.miguelfagundez.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.devproject.miguelfagundez.awesome_toast.AwesomeToast;

public class MainActivity extends AppCompatActivity {

    // Views
    private TextView next;
    private TextView back;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupWebView();
        setupListeners();
    }

    private void setupViews() {
        next = findViewById(R.id.tvNext);
        back = findViewById(R.id.tvBack);
        web = findViewById(R.id.webView);
    }

    private void setupWebView() {
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
        web.loadUrl("https://www.google.com/");
    }

    private void setupListeners() {
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(web.canGoForward()){
                    web.goForward();
                }else{
                    AwesomeToast.errorGradientPeak(getApplicationContext(), "Web cannot go Forward");
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(web.canGoBack()){
                    web.goBack();
                }else{
                    AwesomeToast.errorGradientPeak(getApplicationContext(), "Web cannot go Back");
                }
            }
        });

    }

    @Override
    public void onBackPressed() {

        if (web.canGoBack()){
            web.goBack();
            return;
        }else{
            AwesomeToast.errorGradientPeak(getApplicationContext(), "Web cannot go Back");
        }

        super.onBackPressed();
    }
}