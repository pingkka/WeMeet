package com.example.friend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.friend.databinding.ActivityFriendRequestBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class FriendRequestActivity extends AppCompatActivity {

    ArrayList<Profile> mRequests = new ArrayList<>();
    ActivityFriendRequestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFriendRequestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mShowRequest();

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void mShowRequest() { // 친구 신청 목록 보여주기
        // 여기서부터 ------------------------------------------------------------------------------
        Random r = new Random();
        int num = r.nextInt(2); // 랜덤 숫자 받아오기 0~1

        if (num > 0) {

            // 친구 신청 목록
            String[] friend = {"한성대", "BUG", "모바일소프트웨어트랙", "컴퓨터공학부", "웹공학트랙"};
            int[] image = {R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground};

            // mProfiles 리스트에 친구 목록 추가
            for(int i=0; i<friend.length; i++) {
                String name = friend[i];
                int img = image[i];
                mRequests.add(new Profile(img, name));
            }

            // 사전순 정렬
            Collections.sort(mRequests);
        }
        // 여기까지 수정----------------------------------------------------------------------------
        // 그에 따라 친구 신청 목록에 건수가 달라짐.

        // 어댑터 할당
        MyAdapterRequest adapter = new MyAdapterRequest(mRequests, this);
        binding.rvRequest.setAdapter(adapter);
        binding.rvRequest.setLayoutManager(new LinearLayoutManager(this));
        binding.rvRequest.setHasFixedSize(true);

        adapter.notifyItemInserted(0);
    }
}