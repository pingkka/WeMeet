package com.example.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.friend.databinding.ActivityMemberPositionBinding;

import net.daum.mf.map.api.MapView;

public class MemberPosition extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_member_position);

        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = findViewById(R.id.mapView);
        mapViewContainer.addView(mapView);

    }
}