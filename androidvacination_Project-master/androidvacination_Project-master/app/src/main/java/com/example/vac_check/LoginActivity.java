        /************************************************
         * 		AppCoordinator.swift(LoginActivity)     *
         * 		COMP313.Section. 002                    *
         * 		Created by Group5 on 12.04.2022         *
         * 		User Login                              *
         ************************************************/

package com.example.vac_check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    private EditText UserName;
    private EditText Password;
    private Button Login;
    private Spinner ct;

    public static final String EXTRA_MESSAGE = "qrCodeData";
    public static final String EXTRA_NAME = "name";

    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserName = (EditText)findViewById(R.id.LoginUserName);
        Password = (EditText)findViewById(R.id.LoginPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        ct = (Spinner)findViewById(R.id.spinner);

        SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(LoginActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.usertype));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ct.setAdapter(myAdapter);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AndroidNetworking.post("https://classvaccheck.herokuapp.com/users/login")
                        .addBodyParameter("username", UserName.getText().toString())
                        .addBodyParameter("password", Password.getText().toString())
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    token = (String) response.get("token");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                String innerName = UserName.getText().toString();
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putString(MainMenuActivity.SHARED, innerName);
                                editor.putString(MainMenuActivity.QR_SHARED, token); // kalsın şimdilik
                                editor.commit();

                                MainMenuActivity.AUTH_TOKEN = token;

                                AndroidNetworking.post("https://classvaccheck.herokuapp.com/vaxx/create")
                                        .addHeaders("X-Auth-Token", MainMenuActivity.AUTH_TOKEN)
                                        .build().getAsJSONObject(new JSONObjectRequestListener() {
                                    @Override
                                    public void onResponse(JSONObject response) {

                                        String qrCodeData = null;
                                        try {
                                            qrCodeData = (String) response.get("qrCodeUrl");
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }

                                        Intent intent = new Intent(getApplicationContext(), QrActivity.class);
                                        intent.putExtra(EXTRA_MESSAGE, qrCodeData);
                                        intent.putExtra(EXTRA_NAME, innerName);
                                        startActivity(intent);
                                    }

                                    @Override
                                    public void onError(ANError anError) {

                                    }
                                });

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