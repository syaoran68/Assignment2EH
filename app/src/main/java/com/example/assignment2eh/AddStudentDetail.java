package com.example.assignment2eh;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2eh.Adaptor.CourseListAdapter;
import com.example.assignment2eh.Adaptor.SummaryListAdapter;
import com.example.assignment2eh.R;
import com.example.assignment2eh.model.Student;
import com.example.assignment2eh.model.StudentDB;
import com.example.assignment2eh.model.course;

import java.util.ArrayList;


public class AddStudentDetail extends AppCompatActivity {

    protected Menu detailMenu;

    ListView mSummaryView;
    protected CourseListAdapter ad;
    protected Student studenobj;
    course courseObj;
    ArrayList<course> mCourseList;
    StudentDB mStudentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        Student student = new Student("0","0", "0");
        ArrayList<course> courses = new ArrayList<>();
        student.setCourses(courses);

        mStudentDB = new StudentDB(this);
        //mStudentDB.addToStudentList(student);
        //studenobj = mStudentDB.getStudentList().get(mStudentDB.getStudentList().size() - 1);

        mSummaryView = findViewById(R.id.course_list_id);
        ad = new CourseListAdapter(this, student);
        mSummaryView.setAdapter(ad);

        Button addclass = (Button) findViewById(R.id.course_add_button);

        mCourseList = new ArrayList<course>();
        addclass.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                EditText courseIDedit = (EditText) findViewById(R.id.course_id_edit);
                EditText courseGradeedit = (EditText) findViewById(R.id.course_grade_edit);

                courseObj = new course(courseIDedit.getText().toString(),courseGradeedit.getText().toString(), "0");
                mCourseList.add(courseObj);

                ad.UpdateList(mCourseList);
                ad.notifyDataSetChanged();

                courseIDedit.setText("");
                courseGradeedit.setText("");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.detain_menu_list, menu);
        menu.findItem(R.id.action_add).setVisible(false);
        menu.findItem(R.id.action_edit).setVisible(false);
        menu.findItem(R.id.action_done).setVisible(true);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //.. you are now on this option you selected, no what can you do..
        if (item.getItemId() == R.id.action_done) {



            EditText editView = findViewById(R.id.p_first_name_id);
            //studenobj.setFirstName(mStudentDB, editView.getText().toString());
            editView.setEnabled(false);

            EditText editView2 = findViewById(R.id.p_last_name_id);
            //studenobj.setLastName(mStudentDB, editView2.getText().toString());
            editView2.setEnabled(false);

            EditText editView3 = findViewById(R.id.p_student_id);
            //studenobj.setStudentId(mStudentDB, editView3.getText().toString());
            editView3.setEnabled(false);

            studenobj = new Student(editView.getText().toString(), editView2.getText().toString(), editView3.getText().toString());

            if(mCourseList.size() > 0)
            {
                for(int i = 0; i < mCourseList.size(); i++)
                {
                    mCourseList.get(i).setOwner(studenobj.getStudentId());
                }
            }

            studenobj.setCourses(mCourseList);
            mStudentDB.addToStudentList(studenobj);
            onBackPressed();
        }
        else {
            Intent i = new Intent(this, SummaryLV.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public void onBackPressed() {

//        if (studenobj.getStudentId() == "")
//        {
//            studenobj.deleteLastStudent();
//        }
        super.onBackPressed();
    }
}
