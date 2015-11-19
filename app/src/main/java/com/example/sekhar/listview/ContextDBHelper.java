package com.example.sekhar.listview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sekhar on 14/11/2015.
 */
public class ContextDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Context.dbase";
    public static final String CONTEXT_TABLE_NAME = "CurrentContext";
    public static final String CONTEXT_COLUMN_ID = "_id";
    public static final String CONTEXT_COLUMN_PRIOR_VALUE = "ContextPriorValue";
    public static final String CONTEXT_COLUMN_NAME="ContextName";
    public static final String CONTEXT_COLUMN_IMAGE_PATH="ContextImagePath";


    public ContextDBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

     //   Log.d(TAG, "onCreate SQL: " + buildSQL);

        db.execSQL(
                "create table " + CONTEXT_TABLE_NAME + "(" + CONTEXT_COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        CONTEXT_COLUMN_PRIOR_VALUE + " INTEGER," + CONTEXT_COLUMN_NAME + " STRING," + CONTEXT_COLUMN_IMAGE_PATH +
                        " STRING)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CONTEXT_TABLE_NAME);
        onCreate(db);
    }


}

