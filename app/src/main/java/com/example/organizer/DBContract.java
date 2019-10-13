package com.example.organizer;
import java.util.*;

import android.provider.BaseColumns;

public final class DBContract implements BaseColumns {
    private DBContract() {}

    public static class DBEntry implements BaseColumns {
        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_NAME_VALUE = "value";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_NEXT = "next";
    }
}
