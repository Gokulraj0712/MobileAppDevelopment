        /************************************************************
         * 		AppCoordinator.swift(BusinessRegisterActivity)      *
         * 		COMP313.Section. 002                                *
         * 		Created by Group5 on 12.04.2022                     *
         * 		Registration page for business                      *
         ************************************************************/

package com.example.vac_check;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class BusinessRegisterActivity extends AppCompatActivity {
    private EditText NameofBusiness;
    private EditText Address;
    private EditText BusinessContactNumber;
    private EditText BusinessUserName;
    private EditText BusinessPassword;
    private Button BusinessRegister;
    private String token;

    public static final String EXTRA_MESSAGE = "qrCodeData";
    public static final String EXTRA_NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_businessregister);
        NameofBusiness = (EditText)findViewById(R.id.nb);
        Address = (EditText)findViewById(R.id.Address);
        BusinessContactNumber = (EditText)findViewById(R.id.ContactNumberb);
        BusinessUserName = (EditText)findViewById(R.id.BusinessRegisterUserName);
        BusinessPassword = (EditText)findViewById(R.id.BusinessRegisterPassword);
        BusinessRegister = (Button)findViewById(R.id.BusinessRegisterButton);


        BusinessRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AndroidNetworking.post("https://classvaccheck.herokuapp.com/users/register")
                        .addBodyParameter("name", NameofBusiness.getText().toString())
                        .addBodyParameter("phoneNumber", BusinessContactNumber.getText().toString())
                        .addBodyParameter("email", "")
                        .addBodyParameter("userType", "1")
                        .addBodyParameter("password", BusinessPassword.getText().toString())
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                try {
                                    token = (String) response.get("token");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                String innerName = BusinessUserName.getText().toString();
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

                                        Intent intent = new Intent(getApplicationContext(), SelfScreeningActivity.class);
                                        intent.putExtra(EXTRA_MESSAGE, qrCodeData);
                                        intent.putExtra(EXTRA_NAME, innerName);
                                        Toast.makeText(BusinessRegisterActivity.this, "User Registered Successfully!",
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


}