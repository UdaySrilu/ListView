package com.example.sekhar.listview;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ImageView;

import java.io.File;
import java.util.List;

public class ListviewAdapter extends CursorAdapter {
    //Context context;
    public ContextDBHelper  DbHelper;
    public ListviewAdapter(Context context, Cursor cursor) {
        super(context, cursor, 0);
    }



    // The newView method is used to inflate a new view and return it,
    // you don't bind any data to the view at this point.
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_listview, parent, false);
    }
    // The bindView method is used to bind all data to a given view
    // such as setting the text on a TextView.
    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        //  String path = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.CONTEXT_COLUMN_IMAGE_PATH));
        //File imgFile = new File(path);
        if (isExternalStorageReadable()) {

            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath();
            path = path + "/Screenshots";
            File file = new File(path);
             for (File fileEntry : file.listFiles()) {
                    System.out.println("Suresh Eaturi====>"+fileEntry.getName());
                    Bitmap myBitmap = BitmapFactory.decodeFile(fileEntry.getAbsolutePath());

                    ImageView myImage = (ImageView) view.findViewById(R.id.img);

                    myImage.setImageBitmap(myBitmap);

            }

            // Find fields to populate in inflated template

        }
    }

    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) || Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        } else {
            return false;
        }

    }
}