package com.example.assignment2eh.model;

public class course {

    protected String mCourseID;
    protected String mGrade;

    public course(String course, String grade)
    {
        mCourseID = course;
        mGrade = grade;
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
}


