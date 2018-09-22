package com.example.dell.database;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.example.dell.database.MainActivity.dataAdapter;
import static com.example.dell.database.MainActivity.noteDataList;

public class edit extends AppCompatActivity {
    private Button back;
    private TextView accomplish;
    private EditText edit;
    NoteData note;
    public static int position;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
         accomplish = findViewById(R.id.accomplish);
         back = findViewById(R.id.cancle);
         edit = findViewById(R.id.edit_show);
        //从list中获取信息
        position = getIntent().getIntExtra("position", 0);
        note = noteDataList.get(position);
        Log.e("", "onCreate: "+position+note.getDatabody() );
        edit.setText(note.getDatabody());
        note.save();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    note.setDatabody(edit.getText().toString());
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH) + 1;
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int hour = calendar.get(Calendar.HOUR_OF_DAY);
                    int minute = calendar.get(Calendar.MINUTE);
                    int second = calendar.get(Calendar.SECOND);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                    note.setDatatime(format.format(calendar.getTime()));
                    note.save();
                    Toast.makeText(com.example.dell.database.edit.this, "已保存", Toast.LENGTH_SHORT).show();
                    dataAdapter.notifyDataSetChanged();
                    finish();

            }
        });
        accomplish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    note.setDatabody(edit.getText().toString());
                    Calendar calendar = Calendar.getInstance();
                    int year = calendar.get(Calendar.YEAR);
                    int month = calendar.get(Calendar.MONTH) + 1;
                    int day = calendar.get(Calendar.DAY_OF_MONTH);
                    int hour = calendar.get(Calendar.HOUR_OF_DAY);
                    int minute = calendar.get(Calendar.MINUTE);
                    int second = calendar.get(Calendar.SECOND);
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                    note.setDatatime(format.format(calendar.getTime()));
                    note.save();
                    Toast.makeText(com.example.dell.database.edit.this, "已保存", Toast.LENGTH_SHORT).show();
                    dataAdapter.notifyDataSetChanged();
                    finish();

            }
        });

    }
}
