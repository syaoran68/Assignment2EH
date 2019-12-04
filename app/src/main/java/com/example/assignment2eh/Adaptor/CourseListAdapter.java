package com.example.assignment2eh.Adaptor;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assignment2eh.R;
import com.example.assignment2eh.StudentDetailsActivity;
import com.example.assignment2eh.model.Student;
import com.example.assignment2eh.model.StudentDB;
import com.example.assignment2eh.model.course;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseListAdapter extends BaseAdapter {




    private ArrayList<course> mCourseList;
    StudentDB mStudentDB;

    @Override
    public int getCount() {

        return mCourseList.size();
    }

    public CourseListAdapter (Context context, Student student) {
        mStudentDB = new StudentDB(context);
        mCourseList = student.getCourses();
    }

    public void UpdateList(ArrayList<course> courses)
    {
        mCourseList = courses;
    }

    @Override
    public Object getItem(int i)
    {
        return mStudentDB.getStudentList().get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup)
    {
        View row_view;

        if(view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.courses_row, viewGroup, false);

        }
        else
        {
            row_view = view;
        }

        //


        ((TextView) row_view.findViewById(R.id.course_id)).setText(mCourseList.get(i).getCourseID());

        ((TextView) row_view.findViewById(R.id.course_grade)).setText(mCourseList.get(i).getGrade());


        row_view.setTag(new Integer(i));


        return row_view;
    }
}
