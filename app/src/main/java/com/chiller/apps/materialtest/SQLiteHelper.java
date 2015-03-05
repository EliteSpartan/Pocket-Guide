package com.chiller.apps.materialtest;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Anthony on 4/03/2015.
 */
public class SQLiteHelper extends SQLiteAssetHelper {

    Context myContext;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "pc_data.db";

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void createDataBase() throws IOException {
        boolean mDataBaseExist = checkDataBase();
        if (!mDataBaseExist) {
            this.getReadableDatabase();
            try {
                copyDataBase(DATABASE_NAME);
            } catch (IOException mIOException) {
                mIOException.printStackTrace();
                throw new Error("Error copying database");
            } finally {
                this.close();
            }
        }
    }

    public void copyDataBase(String dbName) throws IOException{

        InputStream inputStream = myContext.getAssets().open(dbName);
        String outFileName = "/data/data/com.chiller.apps.materialtest/databases/" + dbName; //myContext.getFilesDir().getPath()
        OutputStream outputStream = new FileOutputStream(outFileName);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }

        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }

    private boolean checkDataBase() {
        try {
            final String mPath = "/data/data/com.chiller.apps.materialtest/databases/" + DATABASE_NAME;
            final File file = new File(mPath);
            if (file.exists())
                return true;
            else
                return false;
        } catch (SQLiteException e) {
            e.printStackTrace();
            return false;
        }
    }
}
