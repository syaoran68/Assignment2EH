package com.example.assignment2eh.model;

import java.util.ArrayList;

public class person {
    protected String mFirstName;
    protected String mLastName;

    protected ArrayList<course> mCourses;


    public String getFirstName() {
        return mFirstName;
    }

    public person(String fName, String lName) {
        mFirstName = fName;
        mLastName = lName;
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

    public ArrayList<course> getCourses() {
        return mCourses;
    }

    public void setCourses(ArrayList<course> courses) {
        mCourses = courses;
    }
}
