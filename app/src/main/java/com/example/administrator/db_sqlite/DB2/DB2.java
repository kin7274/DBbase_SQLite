package com.example.administrator.db_sqlite.DB2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.db_sqlite.R;

public class DB2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db2);

        final DBHelper2 dbHelper = new DBHelper2(getApplicationContext(), "NEEDLE.db", null, 1);

        final TextView result = (TextView) findViewById(R.id.result);
        final EditText etItem = (EditText) findViewById(R.id.item);

        Button insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = etItem.getText().toString();
                Toast.makeText(getApplicationContext(), "" + item, Toast.LENGTH_SHORT).show();
                dbHelper.insert(item);
                result.setText(dbHelper.getResult());
            }
        });

        Button delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = etItem.getText().toString();
                dbHelper.delete(item);
                result.setText(dbHelper.getResult());
            }
        });

        Button select = (Button) findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(dbHelper.getResult());
            }
        });
    }
}