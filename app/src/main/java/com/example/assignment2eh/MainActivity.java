package com.example.assignment2eh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.assignment2eh.model.course;
import com.example.assignment2eh.model.person;
import com.example.assignment2eh.model.persondb;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createPersonObjects();

        setContentView(R.layout.activity_main);
    }


    protected void createPersonObjects() {
        ArrayList<person> persons = new ArrayList<>();

        person person = new person("James", "Shen");
        ArrayList<course> courses = new ArrayList<>();
        courses.add(new course("CPSC401", "A"));
        courses.add(new course("Math270b", "B"));
        persons.add(person);


        person = new person("John", "Chang");
        courses = new ArrayList<>();
        courses.add(new course("ACCT101", "A"));
        courses.add(new course("Math350", "B"));
        persons.add(person);

        persondb.getOurInstance().setPersonList(persons);

    }

}
