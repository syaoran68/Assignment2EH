package com.example.assignment2eh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.assignment2eh.model.Student;
import com.example.assignment2eh.model.Studentdb;
import com.example.assignment2eh.model.course;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //createPersonObjects();

        setContentView(R.layout.person_list);

        root = findViewById(R.id.student_list);

        ArrayList<Student> studentList = Studentdb.getInstance().getStudentList();
        for(int i = 0; i < studentList.size(); i++)
        {
            Student p = studentList.get(i);
            //
            LayoutInflater inflater = LayoutInflater.from(this);
            View row_view = inflater.inflate(R.layout.student_row, root, false);
            //
            ((TextView) row_view.findViewById(R.id.first_name)).setText(p.getFirstName());
            root.addView(row_view);
        }
    }


}
