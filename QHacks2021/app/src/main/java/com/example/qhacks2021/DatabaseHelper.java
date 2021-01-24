package com.example.qhacks2021;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "users.db";
    public static final String TABLE_NAME = "user_data_table";
    public static final String COL_1 = "USER_ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "EMAIL";
    public static final String COL_4 = "BIRTHDATE";
    public static final String COL_5 = "HEALTH_CARD_NUM";
    public static final String COL_6 = "IS_VACCINATED_COVID";
    public static final String COL_7 = "QR_CODE";
    public static final String COL_8 = "PIN";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (USER_ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, EMAIL TEXT, BIRTHDATE TEXT, HEALTH_CARD_NUM INTEGER, IS_VACCINATED_COVID TEXT, QR_CODE INTEGER, PIN INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String email, String birthdate, String health_card_num, String is_vaccinated_covid, String qr_code, String pin) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, email);
        contentValues.put(COL_4, birthdate);
        contentValues.put(COL_5, health_card_num);
        contentValues.put(COL_6, is_vaccinated_covid);
        contentValues.put(COL_7, qr_code);
        contentValues.put(COL_8, pin);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return  true;
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public boolean updatePassword(String pin){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_8, pin);
        db.update(TABLE_NAME, contentValues, "PIN = 9876", new String[] { pin });
        return true;
    }
}
