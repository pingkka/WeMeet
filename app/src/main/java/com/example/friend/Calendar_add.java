package com.example.friend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//2-2 일정 추가하는 창
public class Calendar_add extends AppCompatActivity {
    private EditText edit_name, edit_memo;
    private Button btn_save, btn_cancel;
    private String name, memo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_add);

        edit_memo = (EditText)findViewById(R.id.edit_cmemo);
        edit_name = (EditText)findViewById(R.id.edit_cname);
        btn_cancel = (Button)findViewById(R.id.btn_cancel);
        btn_save = (Button)findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = edit_name.getText().toString().trim();
                memo = edit_memo.getText().toString().trim();
                if(name.getBytes().length <= 0) {//빈값이 넘어올때의 처리

                    Toast.makeText(getApplicationContext(), "값을 입력하세요.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra("cname",name);
                    intent.putExtra("cmemo",memo);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}