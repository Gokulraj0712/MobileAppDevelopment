
        /********************************************************
         * 		AppCoordinator.swift(UserTypeActivity)          *
         * 		COMP313.Section. 002                            *
         * 		Created by Group5 on 12.04.2022                 *
         *      Identifying type of user                        *
         ********************************************************/

package com.example.vac_check;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class UserType extends AppCompatActivity {
    private Button Visitor;
    private Button Business;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usertype);
        Visitor = (Button)findViewById(R.id.visitor);
        Visitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), VisitorRegisterActivity.class);
                startActivity(intent);
            }
        });
        Business = (Button)findViewById(R.id.business);
        Business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(), BusinessRegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
