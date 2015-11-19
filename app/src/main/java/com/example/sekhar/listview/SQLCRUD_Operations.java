package com.example.sekhar.listview;

/**
 * Created by Sekhar on 15/11/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by KrissRaj on 28-10-2015.
 */
public class SQLCRUD_Operations {

    private ContextDBHelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    Date date = new Date();



    public SQLCRUD_Operations(Context c) {
        ourcontext = c;
    }

    public SQLCRUD_Operations open() throws SQLException {
        dbhelper = new ContextDBHelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbhelper.close();
    }

    public boolean insertContact(int value, String name, String path) {


        ContentValues contentValues = new ContentValues();
        contentValues.put(dbhelper.CONTEXT_COLUMN_PRIOR_VALUE, value);
        contentValues.put(dbhelper.CONTEXT_COLUMN_NAME, name);
        contentValues.put(dbhelper.CONTEXT_COLUMN_IMAGE_PATH, path);
        // contentValues.put("street", street);
        //contentValues.put("place", place);
        database.insert(dbhelper.CONTEXT_TABLE_NAME, null, contentValues);
        return true;
    }


    public int updateColumn(String oldPro, String newPro) {
        ContentValues values = new ContentValues();
        values.put(dbhelper.CONTEXT_COLUMN_IMAGE_PATH, newPro);
        return database.update(dbhelper.CONTEXT_TABLE_NAME, values, dbhelper.CONTEXT_COLUMN_IMAGE_PATH + " = '" + oldPro + "'", null);

    }
    public Cursor getData(int id1) {
       // SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = database.rawQuery("SELECT * FROM " + dbhelper.CONTEXT_TABLE_NAME + " WHERE " + dbhelper.CONTEXT_COLUMN_PRIOR_VALUE + " = " + id1, null);
        return res;
    }

}