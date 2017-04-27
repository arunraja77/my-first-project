package com.example.myfirstproject.dal;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.example.myfirstproject.bal.BusinessAccessLayer;

/**
 * Created by next on 28/4/16.
 */
public class    DataAccessLayer {

    protected static final String TAG="sampleproject_DataAccessLayer";
    protected static final String CREATETABLE="CREATE TABLE IF NOT EXISTS";
    protected static final String DROPTABLE="DROP TABLE IF EXISTS";

    protected static DatabaseHelper mDbHelper;
    protected static SQLiteDatabase mDb;
    protected Context mCtx;

    protected static final String TRN_EMPLOYEE = CREATETABLE +" "
            + BusinessAccessLayer.DATABASE_TABLE_TRN_EMPLOYEE + "("
            + BusinessAccessLayer.EMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, "
            + BusinessAccessLayer.TRN_EMP_FIRSTNAME + " TEXT,"
            + BusinessAccessLayer.TRN_EMP_LASTNAME + " TEXT,"
            + BusinessAccessLayer.TRN_EMP_USERNAME + " TEXT,"
            + BusinessAccessLayer.TRN_EMP_NEWPASSWORD + " TEXT);";


    public DataAccessLayer(Context ctx) {
        this.mCtx = ctx;
    }

    public DataAccessLayer open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public static void close() {
        mDbHelper.close();
    }


    protected static class DatabaseHelper extends SQLiteOpenHelper {

        public DatabaseHelper(Context context) {
            super(context, BusinessAccessLayer.DATABASE_NAME, null, BusinessAccessLayer.DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(TRN_EMPLOYEE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


}
