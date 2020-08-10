package com.example.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import net.daum.mf.map.api.MapView;

public class InformLocationMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inform_location_map);
        Button list_btn = (Button) findViewById(R.id.list_location_btn);

        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = findViewById(R.id.location_map_view);
        mapViewContainer.addView(mapView);

        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}