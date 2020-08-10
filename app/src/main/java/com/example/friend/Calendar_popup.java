package com.example.friend;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


//2 캘린더에서 날짜 클릭했을 때 뜨는 팝업창
public class Calendar_popup extends Activity {
    private int year, month, day;
    private TextView mText_date;
    private Button mBtn_add;
    private String add_name, add_memo;
    private ListView mListview;
    private ArrayAdapter<String> adapter;
    //나중에 서버 연결해서 변경해야됨
    private ArrayList<String> cname = new ArrayList<>();
    private ArrayList<String> cmemo = new ArrayList<>();
    private int edit_num;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        cname.add("회의");
        cmemo.add("1시 한성대입구역");
        cname.add("저녁");
        cmemo.add("ㅇㄻㅇㄻㄴㅇㅁㅇㅁㄹ");

        super.onCreate(savedInstanceState);

        //팝업으로 띄우려면 manifest에서 theme 설정해야됨
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.calendar_list2);
        mText_date = (TextView)findViewById(R.id.text_date);
        mBtn_add = (Button)findViewById(R.id.btn_add);
        mListview = (ListView) findViewById(R.id.listview);
        Intent intent = getIntent();
        year = intent.getIntExtra("year",0);
        month = intent.getIntExtra("month", 0);
        day = intent.getIntExtra("day",0);

        adapter = new ArrayAdapter<String>(this,
                R.layout.calendar_recycler, cname);
        mListview.setAdapter(adapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                edit_num = position;
                Intent intent = new Intent(getApplicationContext(), Calender_edit.class);
                intent.putExtra("list_name", cname.get(position)); //서버 만들고 수정 필요함
                intent.putExtra("list_memo", cmemo.get(position));
                startActivityForResult(intent, 2);

            }
        });


        mText_date.setText(String.format("%d/%d/%d", year,month+1, day));
        mBtn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //일정 추가 버튼 클릭 시
                Intent intent = new Intent(getApplicationContext(), Calendar_add.class);
                startActivityForResult(intent, 1);

            }
        });

    }

    //일정 추가 후 결과 받아옴
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode==RESULT_OK) {
            add_name = data.getStringExtra("cname");
            add_memo = data.getStringExtra("cmemo");

            //나중에 서버 연결하면 변경 할 코드
            cname.add(add_name);
            cmemo.add(add_memo);

            Toast.makeText(this, "저장 완료", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();
        }
        if(requestCode == 2 && resultCode == RESULT_OK) {
            add_name = data.getStringExtra("edit_name");
            add_memo = data.getStringExtra("edit_memo");
            cname.set(edit_num, add_name);
            cmemo.set(edit_num, add_memo);

            Toast.makeText(this, "수정 완료", Toast.LENGTH_SHORT).show();
            adapter.notifyDataSetChanged();




        }
    }


}
