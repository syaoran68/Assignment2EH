package com.example.assignment2eh.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

public class PersistentManager {

    Context mContext;
    SQLiteDatabase mSQLiteDatabase;

    public PersistentManager(Context context) {
        mContext = context;
        File dbFile = mContext.getDatabasePath("student.db");
        SQLiteDatabase.openOrCreateDatabase(dbFile, null);

        // Create (Person/Vehicle) tables if necessary
        mSQLiteDatabase.execSQL("");
    }

    public ArrayList<PersistentObject> retrieveObjects(Class cls) throws Exception {
        ArrayList<PersistentObject> objList = new ArrayList<PersistentObject>();
        String tblName = cls.getSimpleName();
        Cursor cursor = mSQLiteDatabase.query(tblName, null,null,null,null,null,null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                PersistentObject pObj = (PersistentObject) cls.newInstance();
                //pObj.initFrom(cursor);

                objList.add(pObj);
            }
        }
        return objList;
    }
}
