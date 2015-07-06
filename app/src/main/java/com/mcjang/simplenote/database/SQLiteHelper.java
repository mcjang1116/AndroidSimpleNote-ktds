package com.mcjang.simplenote.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.mcjang.simplenote.R;

/**
 * Created by Minchang on 2015-07-01.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    protected static final String DB_NAME = "simplenote";
    private static final int VERSION = 1;

    protected Context context;

    public SQLiteHelper(Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context = context;
    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = context.getString(R.string.CREATE_TABLE);
        query = String.format(query, DB_NAME);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = context.getString(R.string.DROP_TABLE);
        query = String.format(query, DB_NAME);
        db.execSQL(query);
    }
}
