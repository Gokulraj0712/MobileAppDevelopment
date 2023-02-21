
        /********************************************************
         * 		AppCoordinator.swift(SubmitInfoActivity)        *
         * 		COMP313.Section. 002                            *
         * 		Created by Group5 on 12.04.2022                 *
         *      Submitting user information                     *
         ********************************************************/
package com.example.vac_check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
//import com.example.vac_check.databinding.ActivityMainBinding;
import com.example.vac_check.databinding.ActivitySubmitinfoBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class SubmitInfoActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "qrCodeData";
    public static final String EXTRA_NAME = "name";


    private ActivitySubmitinfoBinding binding;
    private String qrCodeData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidNetworking.initialize(getApplicationContext());

        binding = ActivitySubmitinfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        String name = preferences.getString(MainMenuActivity.SHARED, "");
        qrCodeData = preferences.getString(MainMenuActivity.QR_SHARED, "");

        if(!name.isEmpty()) {

            Intent intent = new Intent(getApplicationContext(), QrActivity.class);
            intent.putExtra(EXTRA_MESSAGE, qrCodeData);
            intent.putExtra(EXTRA_NAME, name);
            startActivity(intent);

            finish();
        } else {
        binding.button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                AndroidNetworking.post("https://classvaccheck.herokuapp.com/vaxx/create")
                        .addBodyParameter("name", binding.name.getText().toString() + binding.lastName.getText().toString() + binding.idCard.getText().toString())
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    qrCodeData = (String) response.get("qrCodeUrl");

                                    String innerName = binding.name.getText().toString() + " " + binding.lastName.getText().toString();
                                    SharedPreferences.Editor editor = preferences.edit();
                                    editor.putString(MainMenuActivity.SHARED, innerName);
                                    editor.putString(MainMenuActivity.QR_SHARED, qrCodeData);
                                    editor.commit();

                                    Intent intent = new Intent(getApplicationContext(), QrActivity.class);
                                    intent.putExtra(EXTRA_MESSAGE, qrCodeData);
                                    intent.putExtra(EXTRA_NAME, innerName);
                                    startActivity(intent);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            @Override
                            public void onError(ANError error) {
                                Log.d(String.valueOf(2), "error: ");
                            }
                        });
            }
        });
    }
    }
}