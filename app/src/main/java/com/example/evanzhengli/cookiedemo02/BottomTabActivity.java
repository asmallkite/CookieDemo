package com.example.evanzhengli.cookiedemo02;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.widget.TextView;

public class BottomTabActivity extends AppCompatActivity {
    private static final String TAG = "BottomTabActivity";

    public static String MAIN_URL = "http://www.qq.com/";

    public static String SPORT_URL = "http://sports.qq.com/";
    public static String NEWS_URL = "http://news.qq.com/";

    private TextView mTextMessage;
    private WebView mWebView;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mWebView.loadUrl(MAIN_URL);
                    CookieManager cookieManager3 = CookieManager.getInstance();
                    cookieManager3.setCookie(MAIN_URL, "main=qq.com;Domain=qq.com");
                    String newCookie3 = cookieManager3.getCookie(MAIN_URL);
                    Log.d(TAG, "the coolie is : " + newCookie3);
                    StringBuilder sb = new StringBuilder();
                    sb.append("my url is :").append(MAIN_URL).append("\n")
                            .append("my cookie setting :   ")
                            .append("main=qq.com;Domain=qq.com\n")
                            .append("my cookie is ").append(newCookie3);
                    mTextMessage.setText(sb.toString());
                    return true;
                case R.id.navigation_dashboard:
                    mWebView.loadUrl(SPORT_URL);
                    CookieManager cookieManager2 = CookieManager.getInstance();
                    cookieManager2.setCookie(SPORT_URL, "sports=sports;Domain=sports.qq.com");
                    String newCookie2 = cookieManager2.getCookie(SPORT_URL);
                    Log.d(TAG, "the coolie is : " + newCookie2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("my url is :").append(SPORT_URL).append("\n")
                            .append("my cookie setting :   ")
                            .append("sports=sports;Domain=sports.qq.com\n")
                            .append("my cookie is ").append(newCookie2);
                    mTextMessage.setText(sb2.toString());
                    return true;
                case R.id.navigation_notifications:
                    mWebView.loadUrl(NEWS_URL);
                    CookieManager cookieManager = CookieManager.getInstance();
                    cookieManager.setCookie(NEWS_URL, "news=news;Domain=news.qq.com");
                    String newCookie = cookieManager.getCookie(NEWS_URL);
                    Log.d(TAG, "the coolie is : " + newCookie);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("my url is :").append(NEWS_URL).append("\n")
                            .append("my cookie setting :   ")
                            .append("news=news;Domain=news.qq.com\n")
                            .append("my cookie is ").append(newCookie);
                    mTextMessage.setText(sb3.toString());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_tab);

        mTextMessage = (TextView) findViewById(R.id.message);
        mWebView = findViewById(R.id.webView2);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        CookieManager.getInstance().removeAllCookie();
    }
}
