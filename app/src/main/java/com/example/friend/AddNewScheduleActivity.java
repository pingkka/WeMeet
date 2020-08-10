package com.example.friend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.friend.databinding.ActivityAddNewScheduleBinding;

import java.util.ArrayList;


public class AddNewScheduleActivity extends AppCompatActivity {
    private ActivityAddNewScheduleBinding activityAddNewScheduleBinding;
    //private RecyclerView member_list;
    private MemberAdapter memberAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAddNewScheduleBinding = ActivityAddNewScheduleBinding.inflate(getLayoutInflater());
        setContentView(activityAddNewScheduleBinding.getRoot());

        member_init();

        activityAddNewScheduleBinding.finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ScheduleMainHome.class);
                startActivity(intent);
                //finish();
            }
        });

    }

    private void member_init(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        activityAddNewScheduleBinding.memberView.setLayoutManager(layoutManager);

        ArrayList<Person> member = new ArrayList<>();
        member.add(new Person("이수연"));
        member.add(new Person("이규영"));
        member.add(new Person("민경진"));
        member.add(new Person("최지호"));

        memberAdapter = new MemberAdapter(this, member, onClickItem);
        activityAddNewScheduleBinding.memberView.setAdapter(memberAdapter);

    }

    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String tag = (String) v.getTag();
            Toast.makeText(AddNewScheduleActivity.this, tag, Toast.LENGTH_SHORT).show();
        }
    };
}