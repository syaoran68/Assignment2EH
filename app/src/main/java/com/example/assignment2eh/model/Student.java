package com.example.assignment2eh.model;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected Integer mCWID;

    protected ArrayList<course> mCourses;


    public String getFirstName() {
        return mFirstName;
    }

    public Student(String fName, String lName, Integer id) {
        mFirstName = fName;
        mLastName = lName;
        mCWID = id;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public Integer getCWID() {
        return mCWID;
    }

    public void setCWID(Integer CWID) {
        mCWID = CWID;
    }

    public ArrayList<course> getCourses() {
        return mCourses;
    }

    public void setCourses(ArrayList<course> courses) {
        mCourses = courses;
    }
}
