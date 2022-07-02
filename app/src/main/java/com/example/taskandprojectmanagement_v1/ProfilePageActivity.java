package com.example.taskandprojectmanagement_v1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ProfilePageActivity extends AppCompatActivity {

    Dialog dialog;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile_page);
        Button button = findViewById(R.id.profileDone);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create an intent
                showDialog();
            }
        });
    }

    public void showDialog(){
        dialog = new Dialog(ProfilePageActivity.this);
        dialog.setContentView(R.layout.congratulation_dialog_box);
        dialog.getWindow().getAttributes().windowAnimations = R.style.Animation;
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        Button btn = dialog.findViewById(R.id.GoToHome);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent =new Intent(ProfilePageActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });
        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
    }
}