package com.example.friend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.friend.databinding.ActivityCalcLocationBinding;

public class CalcLocation extends AppCompatActivity {

    private ActivityCalcLocationBinding activityCalcLocationBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCalcLocationBinding = ActivityCalcLocationBinding.inflate(getLayoutInflater());
        setContentView(activityCalcLocationBinding.getRoot());

        activityCalcLocationBinding.pickLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SetLocationPick.class);
                startActivity(intent);
            }
        });
    }

    public void OnClickHandler (View view)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("장소 선택").setMessage("이 곳으로 하시겠습니까?");

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), ScheduleMainHome.class);
                startActivity(intent);
                finish();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}