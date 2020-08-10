package com.example.friend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.example.friend.databinding.ActivityFriendSearchBinding;

import java.util.ArrayList;
import java.util.Collections;

public class FriendSearchActivity extends AppCompatActivity {

    ArrayList<Profile> list = new ArrayList<>(); // 복사본(전체 데이터, 입력된 텍스트와 비교할 리스트)
    ArrayList<Profile> mSearches = new ArrayList<>(); // 검색 결과(띄워주는 리스트)
    ActivityFriendSearchBinding binding;
    MyAdapterSearch adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFriendSearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mShowSearch();
    }

    public void mShowSearch() { // 검색 결과 보여주기
        setting(); // 리스트에 전체 목록(등록된 모든 사용자) 추가

        list.addAll(mSearches); // 전체 목록 복사본

        // 어댑터 할당
        adapter = new MyAdapterSearch(mSearches, this);
        binding.rvSearch.setAdapter(adapter);
        binding.rvSearch.setLayoutManager(new LinearLayoutManager(this));
        binding.rvSearch.setHasFixedSize(true);

        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { // 입력하기 전 처리

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { // 변화와 동시에 처리

            }

            @Override
            public void afterTextChanged(Editable s) { // 입력이 끝났을 때 처리
                String text = binding.etSearch.getText().toString();
                search(text);
            }
        });

        binding.etSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_DOWN) {
                    switch (keyCode) {
                        case KeyEvent.KEYCODE_ENTER: // Enter키 눌렀을 때
                            InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(binding.etSearch.getWindowToken(), 0); // 키보드 숨기기

                            if(mSearches.size() == 0) {
                                Toast.makeText(v.getContext(),"검색결과가 없습니다", Toast.LENGTH_SHORT).show();
                            }
                            return true;
                    }
                }
                return false;
            }
        });
    }

    public void mOnClickSearch(View v) {
        switch (v.getId()) {
            case R.id.imgBack: // 뒤로가기 버튼 눌렀을 때
                finish();
                break;
            case R.id.imgClear: // x 버튼 눌렀을 때
                binding.etSearch.setText(""); // editText 초기화
                break;
        }
    }

    public void search(String text) {

        mSearches.clear(); // mRequests 초기화

        if (text.length() == 0) { // 입력이 없을때
            mSearches.addAll(list); // mRequests에 전체 목록 추가
        }
        else {
            for(int i = 0;i < list.size(); i++) {
                if (list.get(i).getName().toLowerCase().contains(text)) { // 데이터(list)에 text가 포함된 경우
                    mSearches.add(list.get(i)); // mRequests에 추가
                }
            }
        }

        adapter.notifyDataSetChanged(); // adapter 갱신
    }

    public void setting() { // 전체 사용자
        // 여기서부터 ------------------------------------------------------------------------------
        String[] users = {"민경진", "이수연", "이규영", "최지호", "허예원", "박서연", "오아람", "홍승현",
                "경수진", "김대명", "홍길동", "홍길순", "조정석", "정동원", "오정세", "유연석",
                "김호중", "김세정", "상상부기", "서예지", "비", "영탁", "김희재", "김영웅",
                "윤시윤", "유재석", "이찬원", "이효리", "장민호", "정경호", "전미도", "김수현",
                "지석진", "김종국", "송지효", "전소민", "양세찬", "이광수", "하하", "오마이걸",
                "방탄소년단", "싹쓰리", "전소미", "청하", "블랙핑크", "악동뮤지션", "유연정" };

        // mRequests 리스트에 사용자 목록 추가
        for(int i=0; i<users.length; i++) {
            String name = users[i];
            int img = R.drawable.ic_launcher_foreground;
            mSearches.add(new Profile(img, name));
        }

        // 사전순 정렬
        Collections.sort(mSearches);
        // 여기까지 수정 ---------------------------------------------------------------------------
        // 1. 전체 사용자를 처음부터 사전순으로
        // 2. Collections.sort(mRequests); 사용
    }
}