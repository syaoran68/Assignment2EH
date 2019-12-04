package com.example.assignment2eh.model;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class course extends PersistentObject{

    protected String mCourseID;
    protected String mGrade;
    protected String mOwner;

    public course () {}

    public course(String course, String grade, String owner)
    {
        mCourseID = course;
        mGrade = grade;
        mOwner = owner;
    }


    public String getCourseID() {
        return mCourseID;
    }

    public void setCourseID(String courseID) {
        mCourseID = courseID;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String owner) {
        mOwner = owner;
    }

    @Override
    public void insert(SQLiteDatabase db) {
        ContentValues vals = new ContentValues();
        vals.put("Course", mCourseID);
        vals.put("Grade", mGrade);
        vals.put("Student", mOwner);
        db.insert("Course", null, vals);
    }

    @Override
    public void initFrom(Cursor c, SQLiteDatabase db) {
        mCourseID = c.getString(c.getColumnIndex("Course"));
        mGrade = c.getString(c.getColumnIndex("Grade"));
        mOwner = c.getString(c.getColumnIndex("Student"));
    }
}


