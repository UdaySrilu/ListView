package com.example.sekhar.listview;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //ContextDBHelper DbHelper = new ContextDBHelper(this);

    ListView listview;
   // public ContextDBHelper  DbHelper;
    SQLCRUD_Operations dbconn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = (ListView) findViewById(R.id.list);
        dbconn = new SQLCRUD_Operations(this);
        try {
            dbconn.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        dbconn.insertContact(0, "nike",   "/storage/sdcard0/Pictures/Screenshots/");
        dbconn.insertContact(1, "adidas", "/storage/sdcard0/Pictures");
        //dbconn.updateColumn("/storage/sdcard0/Pictures/Screenshots/Screenshot_2015-09-20-23-10-12.PNG", "/ storage / sdcard0 / Pictures");
        dbconn.updateColumn("/ storage / sdcard0 / Pictures", "/storage/sdcard0/Pictures");
        fillData();


    }

    private void fillData() {

        int id = 1;
        Cursor mcursor = dbconn.getData(id);
        startManagingCursor(mcursor);
        ListviewAdapter adapter = new ListviewAdapter(MainActivity.this, mcursor);
        listview.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
