package com.example.administrator.dbbase_sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteTableLockedException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DBHelper extends SQLiteOpenHelper {

    // DBHelp 생성자로 관리할 DB의 이름과 버전 정보를 받는다
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // 온크리에이트
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE BOOK (_id INTEGER PRIMARY KEY AUTOINCREMENT, item TEXT, price INTEGER)");
//        db.execSQL("CREATE TABLE NEEDLE(_id INTEGER PRIMARY KEY AUTOINCREMENT, item NAME)");
    }

    // DB 업그레이드를 위해 버전이 변경될 때 호출되는 함수
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    // 인썰트
    public void insert(String date, String item, int price) {
        // 읽고 쓰기가 가능하게 DB열기
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("INSERT INTO BOOK VALUES(null, '" + item + "', " + price + ")");
        db.close();
    }

    // 업데이트
    public void update(String item, int price) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE BOOK SET price =" + price + "WHERE item'" + item + "';");
        db.close();
    }

    // 딜리트
    public void delete(String item) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM BOOK WHERE item='" + item + "';");
        db.close();
    }

    // 겟리졀트
    public String getResult() {
        SQLiteDatabase db = getReadableDatabase();
        String result = "";
        // DB에 있는 데이터를 쉽게 처리하기 위해 Cursor를 사용하여 테이블에 있는 모든 데이터 출력
        Cursor cursor = db.rawQuery("SELECT * FROM MONEYBOOK", null);
        while (cursor.moveToNext()) {
            result += cursor.getString(0)
                    + " : "
                    + cursor.getString(1)
                    + " | "
                    + cursor.getInt(2)
                    + "원\n";
        }
        return result;
    }
}