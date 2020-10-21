package com.uzdev.grocery.phoneLoginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.uzdev.grocery.MainActivity;
import com.uzdev.grocery.R;

public class PhoneRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_register);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    public void goToLoginPhone(View view) {
        Intent i=new Intent(PhoneRegisterActivity.this,PhoneLoginActivity.class);
        startActivity(i);
        Animatoo.animateSlideUp(this);
        finish();
    }

    public void goToMainPage(View view) {
        Intent i=new Intent(PhoneRegisterActivity.this, MainActivity.class);
        startActivity(i);
        Animatoo.animateSlideRight(this);
        finish();
    }
}