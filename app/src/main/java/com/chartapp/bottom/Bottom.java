package com.chartapp.bottom;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.chartapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessaging;


public class Bottom extends AppCompatActivity  {


    Toolbar toolbar;
    BottomNavigationView bottom_nav;
    private static final String TAG = "MyActivity";






    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom2);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        bottom_nav = findViewById(R.id.bottomNavView);
        bottom_nav.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout,new ChartFragment()).commit();
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.toolbar)));
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.toolbar));
        fcm();



    }





    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()){
                case R.id.chart_menu:
                    selectedFragment = new ChartFragment();
                    break;
                case R.id.soft_menu:
                    selectedFragment = new SoftFragment();
                    break;
                case R.id.other_menu:
                    selectedFragment = new OtherFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_layout,selectedFragment).commit();
            return true;
        }
    };

public void fcm(){
    FirebaseMessaging.getInstance().getToken()
            .addOnCompleteListener(new OnCompleteListener<String>() {
                @Override
                public void onComplete(@NonNull Task<String> task) {
                    if (!task.isSuccessful()) {
                         Toast.makeText(getApplicationContext(), "Fetching FCM registration token failed",Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String token = task.getResult();
                }
            });
}

    @Override
    protected void onDestroy() {
        toolbar = null;
        bottom_nav = null;
        super.onDestroy();
    }
}