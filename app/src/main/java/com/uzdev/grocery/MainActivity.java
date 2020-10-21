package com.uzdev.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.uzdev.grocery.adapter.PlateAdapter;
import com.uzdev.grocery.emailLoginRegister.EmailLoginActivity;
import com.uzdev.grocery.models.PlateModel;
import com.uzdev.grocery.phoneLoginRegister.PhoneLoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<PlateModel> plateModelList;
    PlateAdapter plateAdapter;
    private LinearLayout contineEmailBtn;
    private LinearLayout continePhoneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        contineEmailBtn = findViewById(R.id.linear1);
        continePhoneBtn = findViewById(R.id.linearLayout2);

        recyclerView = findViewById(R.id.rececler_view_plates);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setKeepScreenOn(true);
        recyclerView.setHasFixedSize(true);


        loadData();

        autoScroll();

        contineEmailBtn.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, EmailLoginActivity.class);
            startActivity(i);
            Animatoo.animateSlideDown(MainActivity.this);

        });
        continePhoneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PhoneLoginActivity.class);
                startActivity(i);
                Animatoo.animateSlideLeft(MainActivity.this);

            }
        });
    }

    private void loadData() {


        plateModelList = new ArrayList<>();
        plateModelList.add(new PlateModel(R.drawable.groceries));
        plateModelList.add(new PlateModel(R.drawable.groceries));
        plateModelList.add(new PlateModel(R.drawable.groceries));
        plateModelList.add(new PlateModel(R.drawable.groceries));
        plateModelList.add(new PlateModel(R.drawable.groceries));
        plateModelList.add(new PlateModel(R.drawable.groceries));
        plateAdapter = new PlateAdapter(plateModelList, this);
        recyclerView.setAdapter(plateAdapter);
        plateAdapter.notifyDataSetChanged();
    }

    private void autoScroll() {
        final int speedScroll = 0;
        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            int count = 0;

            @Override
            public void run() {
                if (count == plateAdapter.getItemCount()) {
                    count = 0;
                }
                if (count < plateAdapter.getItemCount()) {
                    recyclerView.smoothScrollToPosition(++count);
                    handler.postDelayed(this, speedScroll);
                }
            }
        };

        handler.postDelayed(runnable, speedScroll);
    }

    public void goToHomePage(View view) {
        Intent i = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(i);
        Animatoo.animateSlideLeft(this);
        finish();
    }
}