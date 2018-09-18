package com.example.administrator.db_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                // 이건 예시
                Intent intent = new Intent(this, DB.class);
                startActivity(intent);
                break;
            case R.id.btn2:
                // 이건 내가 쓸꺼
                Intent intent2 = new Intent(this, DB2.class);
                startActivity(intent2);
                break;
        }
    }
}
