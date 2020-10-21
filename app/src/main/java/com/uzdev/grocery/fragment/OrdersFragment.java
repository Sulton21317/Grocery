package com.uzdev.grocery.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.uzdev.grocery.R;

public class OrdersFragment extends Fragment implements View.OnClickListener {
    DrawerLayout drawerLayout;
    ImageView navigationBar;
    NavigationView navigationView;

    private View v;
    RelativeLayout signUpLogin, Bookmarks, eightMM;
    TextView yourOrder, favoriteOrder, yourAddress, onlineHelp, sendFeedBack, reportSecurity, rateUs;

    public OrdersFragment() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onSetNavigationDrawerEvents();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_orders, container, false);
        return v;
    }


    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout) v.findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) v.findViewById(R.id.navigationView);

        //drawerLayout.openDrawer(GravityCompat.START);
        navigationBar = (ImageView) v.findViewById(R.id.navigationBar);


        signUpLogin = (RelativeLayout) v.findViewById(R.id.relativeLayout2);
        Bookmarks = (RelativeLayout) v.findViewById(R.id.relativeLayout3);
        eightMM = (RelativeLayout) v.findViewById(R.id.relativeLayout4);

        yourOrder = v.findViewById(R.id.your_order);
        favoriteOrder = v.findViewById(R.id.favorite_order);
        yourAddress = v.findViewById(R.id.your_address);
        onlineHelp = v.findViewById(R.id.online_ordesing_help);
        sendFeedBack = v.findViewById(R.id.send_feedback);
        reportSecurity = v.findViewById(R.id.report_security);
        rateUs = v.findViewById(R.id.rate_us);


        navigationBar.setOnClickListener(this);

        signUpLogin.setOnClickListener(this);
        Bookmarks.setOnClickListener(this);
        eightMM.setOnClickListener(this);

        yourOrder.setOnClickListener(this);
        favoriteOrder.setOnClickListener(this);
        yourAddress.setOnClickListener(this);
        onlineHelp.setOnClickListener(this);
        sendFeedBack.setOnClickListener(this);
        reportSecurity.setOnClickListener(this);
        rateUs.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;
            case R.id.relativeLayout2:
                showToast("Sign up");
                break;
            case R.id.relativeLayout3:
                showToast("BookMarks");
                break;
            case R.id.relativeLayout4:
                showToast("8MM");
                break;
            case R.id.your_order:
                showToast("Your Order");
                break;
            case R.id.favorite_order:
                showToast("Favourite order");
                break;
            case R.id.your_address:
                showToast("Your Address");
                break;
            case R.id.online_ordesing_help:
                showToast("Help");
                break;
            case R.id.send_feedback:
                showToast("Send feedback");
                break;
            case R.id.report_security:
                showToast("Reoprt");
                break;
            case R.id.rate_us:
                showToast("Rate us");
                break;

            default:
                showToast("Default");

                break;

        }
    }

    private void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}