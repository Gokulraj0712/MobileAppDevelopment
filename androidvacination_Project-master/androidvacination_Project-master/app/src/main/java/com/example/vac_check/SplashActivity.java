
        /*******************************************************
         * 		AppCoordinator.swift(SelfScreeningActivity)     *
         * 		COMP313.Section. 002                            *
         * 		Created by Group5 on 12.04.2022                 *
         *      Main menu when the App launches                 *
         ********************************************************/
package com.example.vac_check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }
}