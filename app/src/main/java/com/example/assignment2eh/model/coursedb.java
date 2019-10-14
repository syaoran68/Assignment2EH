package com.example.assignment2eh.model;

import java.util.ArrayList;

public class coursedb {

    private static final coursedb ourInstance = new coursedb();

    private ArrayList<course> mCourseList;

    static public coursedb getInstance(){
        return ourInstance;

    }

    private coursedb() {
    }

    public ArrayList<course> getCourseList() {
        return mCourseList;
    }

    public void setCourseList(ArrayList<course> courseList) {
        mCourseList = courseList;
    }
}
