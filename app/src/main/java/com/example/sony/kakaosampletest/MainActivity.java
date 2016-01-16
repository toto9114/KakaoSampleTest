package com.example.sony.kakaosampletest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ChattingAdapter mAdapter;
    TextView inputView;
    RadioGroup categoryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputView = (TextView)findViewById(R.id.edit_message);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ChattingAdapter();
        listView.setAdapter(mAdapter);
        categoryView = (RadioGroup)findViewById(R.id.radio_select);
        Button btn = (Button)findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = categoryView.getCheckedRadioButtonId();
                if(id == R.id.radio_receive){
                    RecieveData rd = new RecieveData();
                    rd.iconId = R.mipmap.ic_launcher;
                    rd.message = inputView.getText().toString();
                    rd.date = new Date().toString();
                    mAdapter.add(rd);
                }
                else {
                    SendData sd = new SendData();
                    sd.iconId = R.mipmap.ic_launcher;
                    sd.message = inputView.getText().toString();
                    sd.date = new Date().toString();
                    mAdapter.add(sd);
                }
                inputView.setText("");
            }
        });
    }
}
