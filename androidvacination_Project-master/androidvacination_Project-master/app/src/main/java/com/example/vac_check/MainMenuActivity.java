        /********************************************************
         * 		AppCoordinator.swift(MainMenuActivity)          *
         * 		COMP313.Section. 002                            *
         * 		Created by Group5 on 12.04.2022                 *
         * 		HomePage                                        *
         ********************************************************/


package com.example.vac_check;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vac_check.databinding.ActivityMainMenuBinding;

public class MainMenuActivity extends AppCompatActivity {

    public static final String SHARED = "shared";
    public static final String QR_SHARED = "QRshared";
    public static boolean IS_VACCINATED= false;

    public static String AUTH_TOKEN = "";

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainMenuBinding binding;
    private Bundle savedInstanceState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMainMenu.toolbar);
        binding.appBarMainMenu.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "You're logged out!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                SharedPreferences preferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString(MainMenuActivity.SHARED, "");
                editor.putString(MainMenuActivity.QR_SHARED, "");
                editor.commit();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //Drawer menu navigation
        NavigationView navigationView1=findViewById(R.id.nav_view);
        navigationView1.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.nav_getQr){
                    Intent intent = new Intent(getApplicationContext(), SubmitInfoActivity.class);
                    startActivity(intent);


                }else if(item.getItemId()==R.id.nav_vax_centre){
                    Intent intent = new Intent(getApplicationContext(), FindVaxCentreActivity.class);
                    startActivity(intent);

                }else if(item.getItemId()==R.id.Self_Screening) {
                    Intent intent = new Intent(getApplicationContext(), SelfScreeningActivity.class);
                    startActivity(intent);

                }else if (item.getItemId()==R.id.nav_home) {
                    Intent intent = new Intent(getApplicationContext(), MainMenuActivity.class);
                    startActivity(intent);
                }

                return false;
            }
        });

        Button btnLogin = (Button) findViewById(R.id.btn_Login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(),LoginActivity.class);
                startActivity(intent);
            }
        });

        Button btnRegister = (Button) findViewById(R.id.btn_Register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(view.getContext(),UserType.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}