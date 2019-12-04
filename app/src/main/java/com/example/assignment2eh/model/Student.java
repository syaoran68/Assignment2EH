package com.example.assignment2eh.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Student extends PersistentObject{
    protected String mFirstName;
    protected String mLastName;
    protected String mStudentId;
    protected SQLiteDatabase mStudentDB;
    protected ArrayList<course> mCourses;

    public Student (){

    }
    public String getFirstName() {
        return mFirstName;
    }

    public Student(String fName, String lName, String id) {
        mFirstName = fName;
        mLastName = lName;
        mStudentId = id;
    }

    public void setFirstName(StudentDB studentDB, String firstName) {
        mFirstName = firstName;

        ContentValues val = new ContentValues();
        val.put("FirstName", firstName);
        studentDB.getSQLiteDatabase().update("Student", val,"CWID=?", new String[]{mStudentId});

    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(StudentDB studentDB, String lastName) {
        mLastName = lastName;

        ContentValues val = new ContentValues();
        val.put("LastName", lastName);
        studentDB.getSQLiteDatabase().update("Student", val,"CWID=?", new String[]{mStudentId});
    }

    public String getStudentId() {
        return mStudentId;
    }

    public void setStudentId(StudentDB studentDB, String studentId) {
        ContentValues val = new ContentValues();
        val.put("CWID", studentId);
        studentDB.getSQLiteDatabase().update("Student", val,"CWID=?", new String[]{mStudentId});
        ContentValues val2 = new ContentValues();
        val2.put("Student", studentId);
        studentDB.getSQLiteDatabase().update("Course", val2, "Student=?", new String[]{mStudentId} );

        mStudentId = studentId;
    }

    public ArrayList<course> getCourses() {
        return mCourses;
    }


    public void setCourses(ArrayList<course> courses) {
        mCourses = courses;
    }

    public void addCourse(StudentDB  studentDB, course course) {
        ContentValues values = new ContentValues();
        values.put("Course", course.mCourseID);
        values.put("Grade", course.mGrade);
        values.put("Student", course.mOwner);
        studentDB.getSQLiteDatabase().insert("Course", null, values);
        mCourses.add(course);
        studentDB.getSQLiteDatabase().close();

    }

    @Override
    public void insert(SQLiteDatabase db){
        ContentValues vals = new ContentValues();
        vals.put("FirstName", mFirstName);
        vals.put("LastName", mLastName);
        vals.put("CWID", mStudentId);
        db.insert("Student", null, vals);

        if(mCourses != null)
        {
            for (int i = 0; i < mCourses.size(); i++){
                mCourses.get(i).insert(db);
            }
        }

    }

    @Override
    public void initFrom(Cursor c, SQLiteDatabase db) {
        mFirstName = c.getString(c.getColumnIndex("FirstName"));
        mLastName = c.getString(c.getColumnIndex("LastName"));
        mStudentId = c.getString(c.getColumnIndex("CWID"));


        mCourses = new ArrayList<course>();
        Cursor cursor = db.query("Course", null, "Course=?", new String[]{new Integer(mStudentId).toString()},null,null,null);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                course vObj = new course();
                vObj.initFrom(cursor, db);
                mCourses.add(vObj);
            }
        }
    }

//    public void deleteLastStudent()
//    {
//        StudentDB.getInstance().getStudentList().remove(StudentDB.getInstance().getStudentList().size() -1);
//    }
}
