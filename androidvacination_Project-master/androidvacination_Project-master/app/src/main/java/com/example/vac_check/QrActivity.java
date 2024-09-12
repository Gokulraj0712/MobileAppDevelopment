
        /****************************************************
         * 		AppCoordinator.swift(QrActivity)            *
         * 		COMP313.Section. 002                        *
         * 		Created by Group5 on 12.04.2022             *
         * 		QR code scanning                            *
         ****************************************************/

package com.example.vac_check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;

import com.example.vac_check.databinding.ActivityQrBinding;

public class QrActivity extends AppCompatActivity {

    private ActivityQrBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        binding = ActivityQrBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();

        String extraData = intent.getStringExtra(SelfScreeningActivity.EXTRA_MESSAGE);
        String name = intent.getStringExtra(SelfScreeningActivity.EXTRA_NAME);

        String[] separated = extraData.split(",");
        byte[] imageBytes = Base64.decode(separated[1], Base64.DEFAULT);
        Bitmap decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
        binding.qrImageView.setImageBitmap(decodedImage);
        String vaccinateString = MainMenuActivity.IS_VACCINATED ? " is vaccinated" : "is not vaccinated";
        binding.person.setText(name + vaccinateString);
    }
}