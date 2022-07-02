package com.example.taskandprojectmanagement_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class SignUpPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up_page);
    }

    public void SignUpBtn(View view) {
        //create an intent
        Intent intent = new Intent(this, ProfilePageActivity.class);
        startActivity(intent);
        finish();
    }

    public void SignInWithFacebook(View view) {
        //create an intent
        Intent intent = new Intent(this, ProfilePageActivity.class);
        startActivity(intent);
        finish();
    }

    public void SignInWithGoogle(View view) {
        //create an intent
        Intent intent = new Intent(this, ProfilePageActivity.class);
        startActivity(intent);
        finish();
    }

    public void SignInWithApple(View view) {
        //create an intent
        Intent intent = new Intent(this, ProfilePageActivity.class);
        startActivity(intent);
        finish();
    }

    public void SignIn(View view) {
        //create an intent
        Intent intent = new Intent(this, SignInPageActivity.class);
        startActivity(intent);
    }
}