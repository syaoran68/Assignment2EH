package com.example.assignment2eh.model;

import java.util.ArrayList;

public class Studentdb {
    private static final Studentdb ourInstance = new Studentdb();

    private ArrayList<Student> mStudentList;

    public static Studentdb getInstance() {
        return ourInstance;
    }

    private Studentdb(){
        createStudentObjects();
    }

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }

    protected void createStudentObjects() {
        ArrayList<Student> students = new ArrayList<>();

        Student student = new Student("James", "Shen", 123456789);
        ArrayList<course> courses = new ArrayList<>();
        courses.add(new course("CPSC401", "A"));
        courses.add(new course("Math270b", "B"));
        students.add(student);


        student = new Student("John", "Chang", 987654321);
        courses = new ArrayList<>();
        courses.add(new course("ACCT101", "A"));
        courses.add(new course("Math350", "B"));
        students.add(student);



    }
}
