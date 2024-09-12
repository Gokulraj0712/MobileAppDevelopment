
        /****************************************************************
         * 		AppCoordinator.swift(VisitorRegisterActivity)           *
         * 		COMP313.Section. 002                                    *
         * 		Created by Group5 on 12.04.2022                         *
         *      Registration for visitor's                              *
         ****************************************************************/

package com.example.vac_check;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class VisitorRegisterActivity extends AppCompatActivity {
    private EditText fullName;
    private EditText email;
    private EditText VisitorContactNumber;
    private EditText VisitorUserName;
    private EditText VisitorPassword;
    private Button VisitorRegister;
    private RadioButton YesButton;
    private RadioButton NoButton;
    private String token;
    private RadioGroup RadioGroupVac;

    public static final String EXTRA_MESSAGE = "qrCodeData";
    public static final String EXTRA_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitorregister);
        fullName = (EditText)findViewById(R.id.Name);
        email = (EditText)findViewById(R.id.Email);
        VisitorContactNumber = (EditText)findViewById(R.id.ContactNumberv);
        VisitorUserName = (EditText)findViewById(R.id.VisitorUserName);
        VisitorPassword = (EditText)findViewById(R.id.VisitorPassword);
        VisitorRegister = (Button)findViewById(R.id.VisitorRegisterButton);
        YesButton = (RadioButton)findViewById(R.id.yesButton);
        NoButton = (RadioButton)findViewById(R.id.noButton);
        RadioGroupVac = (RadioGroup)findViewById(R.id.radioGroupVac);

        VisitorRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AndroidNetworking.post("https://classvaccheck.herokuapp.com/users/register")
                        .addBodyParameter("name", fullName.getText().toString())
                        .addBodyParameter("phoneNumber", VisitorContactNumber.getText().toString())
                        .addBodyParameter("email", email.getText().toString())
                        .addBodyParameter("username", VisitorUserName.getText().toString())
                        .addBodyParameter("userType", "0")
                        .addBodyParameter("password", VisitorPassword.getText().toString())
                        .addBodyParameter("isVaccinated", String.valueOf((YesButton.isChecked() ? 1 : 0)))
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {

                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    token = (String) response.get("token");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                String innerName = VisitorUserName.getText().toString();
                                MainMenuActivity.AUTH_TOKEN = token;
                                MainMenuActivity.IS_VACCINATED = YesButton.isChecked();

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

                                        Intent intent = new Intent(getApplicationContext(), SelfScreeningActivity.class);
                                        intent.putExtra(EXTRA_MESSAGE, qrCodeData);
                                        intent.putExtra(EXTRA_NAME, innerName);
                                        Toast.makeText(VisitorRegisterActivity.this, "User Registered Successfully!",
                                                Toast.LENGTH_LONG).show();
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
    public void OnCheckedChanged(RadioGroup group, int checkId){
        switch (checkId){
            case R.id.yesButton:
                Log.i( "onCheckedChanged","Yes");
                break;
            case R.id.noButton:
                Log.i("onCheckedChanged","No");
                break;
        }
    }

}