package com.example.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.friend.databinding.ActivityScheduleMainHomeBinding;

public class ScheduleMainHome extends AppCompatActivity {
    private ActivityScheduleMainHomeBinding activityScheduleMainHomeBinding;
    private String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityScheduleMainHomeBinding = ActivityScheduleMainHomeBinding.inflate(getLayoutInflater());
        setContentView(activityScheduleMainHomeBinding.getRoot());

        Intent getMainIntent = getIntent();
        String schedule_name = getMainIntent.getStringExtra("schedule_name");
        activityScheduleMainHomeBinding.scheduleName.setText(schedule_name);


        activityScheduleMainHomeBinding.setScheduleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SetScheduleCalender.class);
                startActivity(intent);

                Intent getCalender = getIntent();
                date = getCalender.getStringExtra("Date");
                activityScheduleMainHomeBinding.infromBtn.setText(date);
                //finish();
            }
        });

        activityScheduleMainHomeBinding.setLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SetLocationPick.class);
                startActivity(intent);
            }
        });

        activityScheduleMainHomeBinding.realTimePositionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MemberPosition.class);
                startActivity(intent);
            }
        });

        activityScheduleMainHomeBinding.infromBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InformLocation.class);
                startActivity(intent);
            }
        });


    }
}