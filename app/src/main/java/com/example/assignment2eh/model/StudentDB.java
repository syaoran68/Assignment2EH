package com.example.assignment2eh.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

    public static StudentDB getInstance() {
        return ourInstance;
    }

    private StudentDB(){
        createStudentObjects();
    }

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void addToStudentList(Student student)
    {
        StudentDB.getInstance().mStudentList.add(student);
    }

    protected void createStudentObjects() {

        Student student = new Student("James", "Shen", "123456789");
        ArrayList<course> courses = new ArrayList<>();
        courses.add(new course("CPSC401", "A"));
        courses.add(new course("Math270b", "B"));
        student.setCourses(courses);
        mStudentList = new ArrayList<Student>();
        mStudentList.add(student);


        student = new Student("John", "Chang", "987654321");
        courses = new ArrayList<>();
        courses.add(new course("ACCT101", "A"));
        courses.add(new course("Math350", "B"));
        student.setCourses(courses);
        mStudentList.add(student);



    }
}
