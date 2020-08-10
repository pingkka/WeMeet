package com.example.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.friend.databinding.ActivityInformLocationBinding;

public class InformLocation extends AppCompatActivity {
    private ActivityInformLocationBinding activityInformLocationBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityInformLocationBinding = ActivityInformLocationBinding.inflate(getLayoutInflater());
        setContentView(activityInformLocationBinding.getRoot());

        activityInformLocationBinding.mapLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),InformLocationMap.class);
                startActivity(intent);
                finish();
            }
        });
    }
}