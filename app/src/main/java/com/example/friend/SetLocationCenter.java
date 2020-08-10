package com.example.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.friend.databinding.ActivitySetLocationCenterBinding;

public class SetLocationCenter extends AppCompatActivity {
    private ActivitySetLocationCenterBinding activitySetLocationCenterBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activitySetLocationCenterBinding = ActivitySetLocationCenterBinding.inflate(getLayoutInflater());
        setContentView(activitySetLocationCenterBinding.getRoot());

        activitySetLocationCenterBinding.pickLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        activitySetLocationCenterBinding.calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CalcLocation.class);
                startActivity(intent);
                finish();
            }
        });
    }
}