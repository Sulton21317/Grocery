package com.uzdev.grocery;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.uzdev.grocery.fragment.GoOutFragment;
import com.uzdev.grocery.fragment.GoldFragment;
import com.uzdev.grocery.fragment.OrdersFragment;
import com.uzdev.grocery.fragment.VideoFragment;


public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        setContentView(R.layout.activity_home);
        bottomNavigationView = findViewById(R.id.navigatipn_view);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new OrdersFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectFragment=null;
                switch (item.getItemId()) {
                    case R.id.orders:
                      selectFragment=new OrdersFragment();
                        break;
                    case R.id.goout:
                        selectFragment=new GoOutFragment();

                        break;
                    case R.id.gold:
                        selectFragment=new GoldFragment();

                        break;
                    case R.id.videos:
                        selectFragment=new VideoFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, selectFragment).commit();
                return true;
            }
        });
    }

}