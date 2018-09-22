package com.example.dell.database;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.example.dell.database.MainActivity.dataAdapter;
import static com.example.dell.database.MainActivity.noteDataList;

public class Note extends AppCompatActivity {
    private Button back;
    private TextView accomplish;
    private EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        accomplish = findViewById(R.id.accomplish);
        back = findViewById(R.id.cancle);
        edit = findViewById(R.id.edit_note);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edit.getText().toString().equals("")){
                    finish();
                    return;
                }
                NoteData note = new NoteData();
                note.setDatabody(edit.getText().toString());

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH)+1;
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second  = calendar.get(Calendar.SECOND);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                note.setDatatime(format.format(calendar.getTime()));
                note.save();
                noteDataList.add(note);
                Toast.makeText(com.example.dell.database.Note.this,"已保存",Toast.LENGTH_SHORT).show();
                finish();
                dataAdapter.notifyDataSetChanged();

            }
        });
        accomplish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(edit.getText().toString().equals("")){
                    finish();
                    return;
                }
                //新建表
                NoteData note = new NoteData();
                //设置内容
                note.setDatabody(edit.getText().toString());
                //这里用Calendar方法来获取系统日期
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH)+1;
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                int second  = calendar.get(Calendar.SECOND);
                //设置一下日期显示的格式
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                //按照格式来显示日期
                note.setDatatime(format.format(calendar.getTime()));
                //记得保存
                note.save();
                //添加到notedatalist中
                noteDataList.add(note);
                Toast.makeText(com.example.dell.database.Note.this,"已保存",Toast.LENGTH_SHORT).show();
                finish();
                //recyclerview中更新
                dataAdapter.notifyDataSetChanged();
            }
        });
    }
}
