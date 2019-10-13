package com.example.organizer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import java.util.*;


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

    public void insertNode(Node node) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBContract.DBEntry.COLUMN_NAME_VALUE, node.getValue());
        values.put(DBContract.DBEntry.COLUMN_NAME_DATE, node.getDate());
        values.put(DBContract.DBEntry.COLUMN_NAME_NEXT, node.getNext().getId());

        long newRowID = db.insert(DBContract.DBEntry.TABLE_NAME, null, values);
    }

    public HashMap<Integer, Long> listOrdering() {
        HashMap<Integer, Long> result = new HashMap<Integer, Long>;
        SQLiteDatabase db = this.getReadableDatabase();

        String sortOrder = DBContract.DBEntry.COLUMN_NAME_ORDER + " ASC";

        String[] orderColumns = {
                BaseColumns._ID,
                DBContract.DBEntry.COLUMN_NAME_ORDER
        };

        Cursor cursor = db.query(
                DBContract.DBEntry.TABLE_NAME,
                orderColumns,
                null,
                null,
                null,
                null,
                sortOrder
        );

        while (cursor.moveToNext()) {
            Long itemID = cursor.getLong(cursor.getColumnIndexOrThrow(DBContract.DBEntry._ID));
            Integer itemOrder = cursor.getInt(cursor.getColumnIndexOrThrow(DBContract.DBEntry.COLUMN_NAME_ORDER));
            result.put(itemOrder, itemID);
        }

        cursor.close();
        return result;
    }

    public ToDoList readList() {
        SQLiteDatabase db = this.getReadableDatabase();

        String sortOrder = DBContract.DBEntry.COLUMN_NAME_DATE + " DESC";

        String[] columns = {
            BaseColumns._ID,
            DBContract.DBEntry.COLUMN_NAME_VALUE,
            DBContract.DBEntry.COLUMN_NAME_DATE,
            DBContract.DBEntry.COLUMN_NAME_NEXT
        };

        Cursor cursor = db.query(
            DBContract.DBEntry.TABLE_NAME,
            columns,
            null,
            null,
            null,
            null,
            sortOrder
        );

        HashMap<Integer, Long> order = listOrdering();

        HashMap<Long, Node> tempMap = new HashMap<>();
        while (cursor.moveToNext()) {
            Node node = new Node();
            node.setId(node, cursor.getLong(cursor.getColumnIndexOrThrow(DBContract.DBEntry._ID)));
            node.setValue(node, cursor.getString(cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_VALUE)));
            node.setDate(node, cursor.getString(cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_DATE)));
            // node.setNext(node, cursor.getString(cursor.getColumnIndex(DBContract.DBEntry.COLUMN_NAME_NEXT)));
            tempMap.put(node.getId(), node);
        }

        ToDoList result = new ToDoList();
        for (int i = 0; i < order.size() - 1; i++) {
            Long ID = order.get(i);
            result.add(tempMap.get(ID));
        }
        return result;
    }
}
