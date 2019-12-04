package com.example.assignment2eh.model;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public abstract class PersistentObject {

    public abstract void insert(SQLiteDatabase db);
    public abstract void initFrom(Cursor c, SQLiteDatabase db);

}
