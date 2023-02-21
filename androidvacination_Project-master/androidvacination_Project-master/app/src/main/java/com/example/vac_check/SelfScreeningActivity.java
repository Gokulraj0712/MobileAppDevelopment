
        /************************************************************
         * 		AppCoordinator.swift(FSelfScreeningActivity)        *
         * 		COMP313.Section. 002                                *
         * 		Created by Group5 on 12.04.2022                     *
         *      Visitor's self screening                            *
         ************************************************************/

package com.example.vac_check;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class SelfScreeningActivity extends AppCompatActivity {
    //private CheckBox screen_one_check, screen_two_check, screen_three_check, screen_four_check, screen_five_check;
    private Button submitButton;
    private boolean isSymptomFree= true;

    public static final String EXTRA_MESSAGE = "qrCodeData";
    public static final String EXTRA_NAME = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_screening);
        submitButton = findViewById(R.id.submitButton);

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
        RadioButton rb5 = (RadioButton) findViewById(R.id.radioButton5);
        RadioButton rb6 = (RadioButton) findViewById(R.id.radioButton6);
        RadioButton rb7 = (RadioButton) findViewById(R.id.radioButton7);
        RadioButton rb8 = (RadioButton) findViewById(R.id.radioButton8);
        RadioButton rb9 = (RadioButton) findViewById(R.id.radioButton9);
        RadioButton rb10 = (RadioButton) findViewById(R.id.radioButton10);


        //intit();
        Intent intent = getIntent();

        String qrData = intent.getStringExtra(VisitorRegisterActivity.EXTRA_MESSAGE);
        String userName = intent.getStringExtra(VisitorRegisterActivity.EXTRA_NAME);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                StringBuffer result = new StringBuffer();

                if(rb1.isChecked() || rb3.isChecked() || rb5.isChecked()
                || rb7.isChecked() || rb10.isChecked()){

                    isSymptomFree = false;
                }
                else{
                    isSymptomFree = true;
                }




/*
                result.append("\n");
                if (screen_one_check.isChecked()) {
                    questionList.add(true);


                    result.append(screen_one_check.getText().toString()).append("\n");
                }
               else if (screen_two_check.isChecked()) {

                    result.append(screen_two_check.getText().toString()).append("\n");
                }
                else if (screen_three_check.isChecked()) {

                    result.append(screen_three_check.getText().toString()).append("\n");
                }
               else if (screen_four_check.isChecked()) {

                    result.append(screen_four_check.getText().toString()).append("\n");
                }
                else if (screen_five_check.isChecked()) {

                    result.append(screen_five_check.getText().toString()).append("\n");
                }
                else{

                }
*/
                if(isSymptomFree){
                    Intent intent = new Intent(getApplicationContext(), QrActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, qrData);
                    intent.putExtra(EXTRA_NAME, userName);
                    startActivity(intent);


                    Toast.makeText(SelfScreeningActivity.this, "Successfully submitted!",
                            Toast.LENGTH_LONG).show();


                }else{
                    Toast.makeText(SelfScreeningActivity.this, "Person got symptoms! Cannot create QR code",
                            Toast.LENGTH_LONG).show();
                }


            }

        });

    }


}