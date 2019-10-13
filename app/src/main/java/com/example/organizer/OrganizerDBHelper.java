package com.example.organizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class OrganizerDBHelper extends SQLiteOpenHelper {
    private static final int DATABSE_VERSION = 1;
    private static final String DATABASE_NAME = "organizer.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DBContract.DBEntry.TABLE_NAME + " (" +
                    DBContract.DBEntry._ID + " INTEGER PRIMARY KEY," +
                    DBContract.DBEntry.COLUMN_NAME_VALUE + " TEXT," +
                    DBContract.DBEntry.COLUMN_NAME_DATE + " DATE," + DBContract.DBEntry.COLUMN_NAME_NEXT + " NEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DBContract.DBEntry.TABLE_NAME;


    public OrganizerDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Node node) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.DBEntry.COLUMN_NAME_VALUE, node.getValue());
        values.put(DBContract.DBEntry.COLUMN_NAME_DATE, node.getDate());
        values.put(DBContract.DBEntry.COLUMN_NAME_NEXT, node.getNext().getId());

        long newRowID = db.insert(DBContract.DBEntry.TABLE_NAME, null, values);
    }
}
