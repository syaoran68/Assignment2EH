package com.example.assignment2eh.Adaptor;

import android.content.Context;
import android.database.DatabaseUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.example.assignment2eh.R;
import com.example.assignment2eh.StudentDetailsActivity;
import com.example.assignment2eh.model.Student;
import com.example.assignment2eh.model.StudentDB;

import java.util.ArrayList;

public class SummaryListAdapter extends BaseAdapter {
    ArrayList<Student> mStudentList;
    StudentDB mStudentDB;

    public SummaryListAdapter(Context context){
        mStudentDB = new StudentDB(context);
        mStudentList = mStudentDB.getStudentList();
    }


    @Override
    public int getCount()
    {
        return Math.toIntExact(DatabaseUtils.queryNumEntries(mStudentDB.getSQLiteDatabase(), "Student"));
    }

    @Override
    public Object getItem(int i)
    {
        return mStudentDB.getStudentList().get(i);
    }

    public void updateList(){
        mStudentList = mStudentDB.getStudentList();
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
            row_view = inflater.inflate(R.layout.student_row, viewGroup, false);

        }
        else
        {
            row_view = view;
        }

        //
        Student p = mStudentDB.getStudentList().get(i);

        ((TextView) row_view.findViewById(R.id.first_name)).setText(p.getFirstName());

        ((TextView) row_view.findViewById(R.id.last_name)).setText(p.getLastName());

        ((TextView) row_view.findViewById(R.id.student_id)).setText(p.getStudentId());

        row_view.setTag(new Integer(i));

        row_view.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                       //Toast.makeText(view.getContext(),"View Object was touched by user", Toast.LENGTH_SHORT).show();

                        //Page Navigation
                        Intent intent = new Intent(view.getContext(), StudentDetailsActivity.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );
        return row_view;
    }
}
