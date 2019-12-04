package com.example.assignment2eh;

import android.media.ExifInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.assignment2eh.Adaptor.CourseListAdapter;
import com.example.assignment2eh.model.Student;
import com.example.assignment2eh.model.StudentDB;
import com.example.assignment2eh.model.course;


public class StudentDetailsActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected int studentIndex;
    protected Student studentObj;
    ListView mSummaryView;
    protected CourseListAdapter ad;
    course courseObj;
    StudentDB mStudentDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        studentIndex = getIntent().getIntExtra("StudentIndex", 0);


        //studentObj = StudentDB.getInstance().getStudentList().get(studentIndex);

        mStudentDB = new StudentDB(this);
        studentObj = mStudentDB.getStudentList().get(studentIndex);

        //


        EditText editView = findViewById(R.id.p_first_name_id);
        editView.setText(studentObj.getFirstName());
        editView.setEnabled(false);

        EditText editView2 = findViewById(R.id.p_last_name_id);;
        editView2.setText(studentObj.getLastName());
        editView2.setEnabled(false);

        EditText editView3 = findViewById(R.id.p_student_id);;
        editView3.setText(studentObj.getStudentId());
        editView3.setEnabled(false);

        mSummaryView = findViewById(R.id.course_list_id);
        ad = new CourseListAdapter(this, studentObj);
        mSummaryView.setAdapter(ad);

        Button addclass = (Button) findViewById(R.id.course_add_button);

        addclass.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                EditText courseIDedit = (EditText) findViewById(R.id.course_id_edit);
                EditText courseGradeedit = (EditText) findViewById(R.id.course_grade_edit);

                courseObj = new course(courseIDedit.getText().toString(),courseGradeedit.getText().toString(), studentObj.getStudentId());
                studentObj.addCourse(mStudentDB, courseObj);

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
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) { //.. you are now on this option you selected, no what can you do..
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.p_first_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.p_last_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.p_student_id);
            editView.setEnabled(true);
            //
            item.setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        } else if (item.getItemId() == R.id.action_done) {

            EditText editView = findViewById(R.id.p_first_name_id);
            String firsttest = editView.getText().toString();
            mStudentDB.getStudentList().get(studentIndex).setFirstName(mStudentDB, editView.getText().toString());
            editView.setEnabled(false);

            editView = findViewById(R.id.p_last_name_id);
            mStudentDB.getStudentList().get(studentIndex).setLastName(mStudentDB, editView.getText().toString());
            editView.setEnabled(false);

            editView = findViewById(R.id.p_student_id);

            mStudentDB.getStudentList().get(studentIndex).setStudentId(mStudentDB, editView.getText().toString());
            editView.setEnabled(false);

            item.setVisible(false);
            detailMenu.findItem(R.id.action_edit).setVisible(true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        ad.notifyDataSetChanged();
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


}
