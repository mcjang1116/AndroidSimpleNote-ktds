package com.mcjang.simplenote;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getActionBar().hide();

        // Splash Activity 2.5초 후에 꺼진다.
        Handler hd = new Handler() {
            public void handleMessage(Message msg) {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        };
        hd.sendEmptyMessageDelayed(0, 2500);

    }

    @Override
    public void onBackPressed() {}
}
