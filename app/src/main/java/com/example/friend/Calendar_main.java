package com.example.friend;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

//1 캘린더 메인
public class Calendar_main extends AppCompatActivity {
    CalendarView mCalendar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_main);

        mCalendar=findViewById(R.id.calendarView);


        mCalendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int y, int m,
                                            int d) {
                Intent intent = new Intent(getApplicationContext(), Calendar_popup.class);
                intent.putExtra("year", y);
                intent.putExtra("month", m);
                intent.putExtra("day",d);
                startActivity(intent);
            }
        });

    }

}