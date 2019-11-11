package com.example.assignment2eh.model;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected String mStudentId;

    protected ArrayList<course> mCourses;


    public String getFirstName() {
        return mFirstName;
    }

    public Student(String fName, String lName, String id) {
        mFirstName = fName;
        mLastName = lName;
        mStudentId = id;
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

    public String getStudentId() {
        return mStudentId;
    }

    public void setStudentId(String studentId) {
        mStudentId = studentId;
    }

    public ArrayList<course> getCourses() {
        return mCourses;
    }

    public void setCourses(ArrayList<course> courses) {
        mCourses = courses;
    }

    public void addCourse(course c) {
        mCourses.add(c);
    }

    public void deleteLastStudent()
    {
        StudentDB.getInstance().getStudentList().remove(StudentDB.getInstance().getStudentList().size() -1);
    }
}
