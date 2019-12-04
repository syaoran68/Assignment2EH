package com.example.assignment2eh.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;
import java.util.ArrayList;

public class StudentDB {
    private Context mContext;
    private SQLiteDatabase mSQLiteDatabase;

    //private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

//    public static StudentDB getInstance() {
//        return ourInstance;
//    }

    public StudentDB(Context c){

        mContext = c;
        File dbFile = c.getDatabasePath("student.db");
        mSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase(dbFile, null);
        createSQLTables();
    }

    private StudentDB() { createStudentObjects();}


    public SQLiteDatabase getSQLiteDatabase() {
        return mSQLiteDatabase;
    }


    public ArrayList<Student> getStudentList() {
        ArrayList<Student> StudentList = new ArrayList<Student>();
        Cursor cursor = mSQLiteDatabase.query("Student", null, null, null, null, null,null );
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                Student pObj = new Student();
                pObj.initFrom(cursor, mSQLiteDatabase);

                // new query for list of courses
                ArrayList<course> courses = new ArrayList<course>();

                Cursor cursor2 = mSQLiteDatabase.query("Course", null, "Student=?", new String[]{new Integer(pObj.getStudentId()).toString()},null,null,null);

                if(cursor2.getCount() > 0)
                {
                    while(cursor2.moveToNext()) {
                        course cObj = new course();
                        cObj.initFrom(cursor2, mSQLiteDatabase);
                        courses.add(cObj);

                    }
                }
                pObj.setCourses(courses);
                StudentList.add(pObj);

            }
        }
        mStudentList = StudentList;
        return StudentList;





        //return mStudentList;
    }

    public void addToStudentList(Student student)
    {
        student.insert(mSQLiteDatabase);
    }

    protected void createSQLTables() {
        String sql = "CREATE TABLE IF NOT EXISTS STUDENT (FirstName text, LastName Text, CWID INTEGER)";
        mSQLiteDatabase.execSQL(sql);
        sql = "CREATE TABLE IF NOT EXISTS COURSE (Course text, Grade text, Student INTEGER)";
        mSQLiteDatabase.execSQL(sql);

        ArrayList<Student> StudentList = new ArrayList<Student>();
        Cursor cursor = mSQLiteDatabase.query("Student", null, null, null, null, null,null );
        if (cursor.getCount() <= 0) {
            createStudentObjects();
        }
    }

    protected void createStudentObjects() {

        Student student = new Student("James", "Shen", "123456789");
        ArrayList<course> courses = new ArrayList<course>();
        courses.add(new course("CPSC401", "A", "123456789"));
        courses.add(new course("Math270b", "B", "123456789"));
        student.setCourses(courses);
        mStudentList = new ArrayList<Student>();
        student.insert(mSQLiteDatabase);

        mStudentList.add(student);


        student = new Student("John", "Chang", "987654321");
        courses = new ArrayList<>();
        courses.add(new course("ACCT101", "A", "987654321"));
        courses.add(new course("Math350", "B", "987654321"));
        student.setCourses(courses);

        student.insert(mSQLiteDatabase);
        mStudentList.add(student);



    }
}
