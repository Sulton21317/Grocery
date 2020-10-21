package com.uzdev.grocery.emailLoginRegister;

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

public class EmailRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_register);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void goToLogin(View view) {
        Intent i = new Intent(EmailRegisterActivity.this, EmailLoginActivity.class);
        startActivity(i);
        Animatoo.animateSlideLeft(EmailRegisterActivity.this);
        finish();
    }
    public void goToMainPage(View view) {
        Intent i=new Intent(EmailRegisterActivity.this, MainActivity.class);
        startActivity(i);
        Animatoo.animateSlideUp(this);
        finish();
    }
}