package com.example.campusexpense.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.campusexpense.model.Account;

public class AccountDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "account.db";
    public static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "account";

    public static final String ID = "id";

    public static final String NAME = "name";

    public static final String EMAIL = "email";

    public static final String PASSWORD = "password";


    public AccountDB(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + NAME + " VARCHAR(60),"
                + EMAIL + " VARCHAR(60),"
                + PASSWORD + " VARCHAR(255)"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public long newAccount(String name, String email, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, name);
        values.put(EMAIL, email);
        values.put(PASSWORD, password);
        //check account exists


        long id = db.insert(TABLE_NAME, null, values);
        db.close();
        return id; // if id is -1, then the insert failed
    }


}
